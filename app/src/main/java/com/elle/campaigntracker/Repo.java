package com.elle.campaigntracker;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.elle.campaigntracker.data.AppDatabase;
import com.elle.campaigntracker.data.model.Attack;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.data.model.world.Log;
import com.elle.campaigntracker.data.model.Money;
import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.data.model.CharacterInfo;
import com.elle.campaigntracker.data.model.CharacterSkills;
import com.elle.campaigntracker.util.DeleteItemAsyncTask;
import com.elle.campaigntracker.util.InsertItemAsyncTask;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Handles working with the database
 */

public class Repo {
    private static Repo instance;

    private final AppDatabase database;
    private LiveData<PlayableCharacter> characterLiveData;
    private LiveData<List<Item>> inventoryLiveData;
    private LiveData<Money> moneyLiveData;

    private LiveData<CharacterSkills> skillsLiveData;

    private final int charId;

    private Repo(final AppDatabase database, int charId){
        this.database = database;
        this.charId = charId;
        this.characterLiveData = database.playerCharacterDao().findCharacterById(charId);
        this.inventoryLiveData = database.itemDao().findInventoryForCharacter(charId);
        this.moneyLiveData = database.moneyDao().getMoneyByCharId(charId);

    }

    public static Repo getInstance(final AppDatabase database, int charId){
        if(instance == null){
            synchronized (Repo.class){
                if(instance == null){
                    instance = new Repo(database, charId);
                }
            }
        }
        return instance;
    }

    public LiveData<PlayableCharacter> getCharacterLiveData() {
        return characterLiveData;
    }

    public LiveData<List<Item>> getInventoryLiveData(){
        return inventoryLiveData;
    }

    public LiveData<Money> getMoneyLiveData() {
        return moneyLiveData;
    }

    public void insert(Item item){
        new InsertItemAsyncTask(database.itemDao()).execute(item);
    }

    public void delete(Item item){
        new DeleteItemAsyncTask(database.itemDao()).execute(item);
    }

    public void updateCharacter(final PlayableCharacter playableCharacter){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.playerCharacterDao().updatePlayerCharacter(playableCharacter);
            }
        });
    }

    public void addLog(Log log){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.logDao().insertLog(log);
            }
        });
    }

    public int getCharId() {
        return charId;
    }
}
