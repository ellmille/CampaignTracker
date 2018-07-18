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
    private MediatorLiveData<CharacterSkills> observableStats;
    private MediatorLiveData<CharacterInfo> observableInfo;
    private LiveData<List<Item>> inventoryLiveData;
    private MediatorLiveData<List<Log>> observableLogs;
    private MediatorLiveData<Money> observableMoney;
    private final int charId;

    private Repo(final AppDatabase database, int charId){
        this.database = database;
        this.charId = charId;
        this.characterLiveData = database.playerCharacterDao().findCharacterById(charId);
        this.inventoryLiveData = database.itemDao().findInventoryForCharacter(charId);

        this.observableStats = new MediatorLiveData<>();
        this.observableInfo = new MediatorLiveData<>();
        this.observableLogs = new MediatorLiveData<>();
        this.observableMoney = new MediatorLiveData<>();

        observableStats.addSource(loadCharacterStats(charId), new Observer<CharacterSkills>() {
            @Override
            public void onChanged(@Nullable CharacterSkills characterSkills) {
                observableStats.postValue(characterSkills);
            }
        });

        observableInfo.addSource(loadCharacterInfo(charId), new Observer<CharacterInfo>() {
            @Override
            public void onChanged(@Nullable CharacterInfo characterInfo) {
                observableInfo.postValue(characterInfo);
            }
        });

        observableMoney.addSource(loadMoneyByCharId(charId), new Observer<Money>() {
            @Override
            public void onChanged(@Nullable Money money) {
                observableMoney.postValue(money);
            }
        });

        observableLogs.addSource(loadLogsForCharacter(charId), new Observer<List<Log>>() {
            @Override
            public void onChanged(@Nullable List<Log> logs) {
                observableLogs.postValue(logs);
            }
        });
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

    public void insert(Item item){
        new InsertItemAsyncTask(database.itemDao()).execute(item);
    }

    public void delete(Item item){
        new DeleteItemAsyncTask(database.itemDao()).execute(item);
    }

    public LiveData<CharacterSkills> getCharacterStats(){
        return observableStats;
    }

    public LiveData<CharacterInfo> getCharacterInfo(){
        return observableInfo;
    }

    public LiveData<Money> getMoney(){
        return observableMoney;
    }

    public LiveData<List<Log>> getLogs(){
        return observableLogs;
    }

    public LiveData<PlayableCharacter> loadCharacter(final int charId){
        return database.playerCharacterDao().findCharacterById(charId);
    }

    public LiveData<CharacterSkills> loadCharacterStats(final int charId){
        return database.playableCharacterStatsDao().findStatsById(charId);
    }

    public LiveData<CharacterInfo> loadCharacterInfo(final int charId){
        return database.pcInfoDao().getInfoByCharId(charId);
    }

    public LiveData<List<Log>> loadLogsForCharacter(final int charId){
        return database.logDao().findLogsForCharacter(charId);
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

    public void updateLog(Log log){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.logDao().updateLog(log);
            }
        });
    }

    public void addItem(Item item){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.itemDao().insertItem(item);
            }
        });
    }

    public LiveData<Item> loadItemById(final int id){
        return database.itemDao().findItemById(id);
    }

    public void updateMoney(Money money){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.moneyDao().updateMoney(money);
            }
        });
    }

    public LiveData<Money> loadMoneyByCharId(final int charId){
        return database.moneyDao().getMoneyByCharId(charId);
    }

    public LiveData<List<Attack>> loadAttacksForCharacter(final int charId){
        return database.attackDao().findAttacksForCharacter(charId);
    }

    public int getCharId() {
        return charId;
    }
}
