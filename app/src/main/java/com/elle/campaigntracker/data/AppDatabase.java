package com.elle.campaigntracker.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.elle.campaigntracker.data.dao.AttackDao;
import com.elle.campaigntracker.data.dao.ItemDao;
import com.elle.campaigntracker.data.dao.LogDao;
import com.elle.campaigntracker.data.dao.MoneyDao;
import com.elle.campaigntracker.data.dao.CharacterInfoDao;
import com.elle.campaigntracker.data.dao.CharacterSkillsDao;
import com.elle.campaigntracker.data.dao.PlayerCharacterDao;
import com.elle.campaigntracker.data.model.Attack;
import com.elle.campaigntracker.data.model.category.Converters;
import com.elle.campaigntracker.inventory.Item;
import com.elle.campaigntracker.data.model.world.Log;
import com.elle.campaigntracker.wallet.Money;
import com.elle.campaigntracker.character.PlayableCharacter;
import com.elle.campaigntracker.data.model.CharacterInfo;
import com.elle.campaigntracker.data.model.CharacterSkills;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Holds database
 */
@Database(entities = {PlayableCharacter.class, CharacterSkills.class,
        CharacterInfo.class, Log.class, Item.class, Money.class,
        Attack.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    //todo: remove
    private static DummyRepo dummyRepo = new DummyRepo();

    @VisibleForTesting
    public static final String DATABASE_NAME = "campaign_db";

    //list all daos
    public abstract PlayerCharacterDao playerCharacterDao();
    public abstract CharacterInfoDao playableCharacterStatsDao();
    public abstract CharacterSkillsDao skillsDao();
    public abstract LogDao logDao();
    public abstract ItemDao itemDao();
    public abstract MoneyDao moneyDao();
    public abstract AttackDao attackDao();

    private final MutableLiveData<Boolean> isDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context, final Executor executor){
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = buildDatabase(context.getApplicationContext(), executor);
                    instance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    /**
     * Build the database. {@link Builder#build()} only sets up the database configuration and
     * creates a new instance of the database.
     * The SQLite database is only created when it's accessed for the first time.
     */
    private static AppDatabase buildDatabase(final Context appContext,
                                             final Executor executor) {
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executor.execute(() -> {
                            // Generate the data for pre-population
                            AppDatabase database = AppDatabase.getInstance(appContext, executor);
                            //todo: remove
                            PlayableCharacter playerCharacter = dummyRepo.getPlayableChar();

                            insertData(database, playerCharacter);
                            // notify that the database was created and it's ready to be used
                            database.setDatabaseCreated();
                        });
                    }
                }).build();
    }

    /**
     * Check whether the database already exists and expose it via {@link #getDatabaseCreated()}
     */
    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        isDatabaseCreated.postValue(true);
    }

    private static void insertData(final AppDatabase database, final PlayableCharacter playerCharacter) {
        database.runInTransaction(() -> {
            long id = database.playerCharacterDao().insertPlayerCharacter(playerCharacter);
            int charId = (int) id;
        });
    }

    public LiveData<Boolean> getDatabaseCreated() {
        return isDatabaseCreated;
    }

    public void addAttack(final Attack attack){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                attackDao().insertAttack(attack);
            }
        });
    }
}
