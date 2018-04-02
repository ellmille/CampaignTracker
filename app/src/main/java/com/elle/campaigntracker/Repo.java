package com.elle.campaigntracker;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.elle.campaigntracker.data.AppDatabase;
import com.elle.campaigntracker.data.model.Attack;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.data.model.Log;
import com.elle.campaigntracker.data.model.Money;
import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.data.model.PcInfo;
import com.elle.campaigntracker.data.model.PcStats;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Handles working with the database
 */

public class Repo {
    private static Repo instance;

    private final AppDatabase database;
    private MediatorLiveData<PlayableCharacter> observableCharacter;
    private MediatorLiveData<PcStats> observableStats;
    private MediatorLiveData<PcInfo> observableInfo;
    private MediatorLiveData<List<Item>> observableInventory;
    private MediatorLiveData<List<Log>> observableLogs;
    private MediatorLiveData<Money> observableMoney;
    private final int charId;

    private Repo(final AppDatabase database, int charId){
        this.database = database;
        this.charId = charId;
        this.observableCharacter = new MediatorLiveData<>();
        this.observableStats = new MediatorLiveData<>();
        this.observableInfo = new MediatorLiveData<>();
        this.observableInventory = new MediatorLiveData<>();
        this.observableLogs = new MediatorLiveData<>();
        this.observableMoney = new MediatorLiveData<>();

        observableCharacter.addSource(loadCharacter(charId), new Observer<PlayableCharacter>() {
            @Override
            public void onChanged(@Nullable PlayableCharacter playableCharacter) {
                observableCharacter.postValue(playableCharacter);
            }
        });

        observableStats.addSource(loadCharacterStats(charId), new Observer<PcStats>() {
            @Override
            public void onChanged(@Nullable PcStats pcStats) {
                observableStats.postValue(pcStats);
            }
        });

        observableInfo.addSource(loadCharacterInfo(charId), new Observer<PcInfo>() {
            @Override
            public void onChanged(@Nullable PcInfo pcInfo) {
                observableInfo.postValue(pcInfo);
            }
        });

        observableInventory.addSource(loadItemsForCharacter(charId), new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                observableInventory.postValue(items);
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

    /**
     * Get the list of products from the database and get notified when the data changes.
     */
    public LiveData<PlayableCharacter> getCharacter(){
        return observableCharacter;
    }

    public LiveData<PcStats> getCharacterStats(){
        return observableStats;
    }

    public LiveData<PcInfo> getCharacterInfo(){
        return observableInfo;
    }

    public LiveData<Money> getMoney(){
        return observableMoney;
    }

    public LiveData<List<Item>> getInventory(){
        return observableInventory;
    }

    public LiveData<List<Log>> getLogs(){
        return observableLogs;
    }

    public LiveData<PlayableCharacter> loadCharacter(final int charId){
        return database.playerCharacterDao().findCharacterById(charId);
    }

    public LiveData<PcStats> loadCharacterStats(final int charId){
        return database.playableCharacterStatsDao().findStatsById(charId);
    }

    public LiveData<PcInfo> loadCharacterInfo(final int charId){
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

    public LiveData<List<Item>> loadItemsForCharacter(final int charId){
        return database.itemDao().findInventoryForCharacter(charId);
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

    public void updateItem(Item item){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                if(item.getId() > 0){
                    database.itemDao().updateItem(item);
                }else{
                    database.itemDao().insertItem(item);
                }

            }
        });
    }

    public void deleteItem(Item item){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.itemDao().deleteItem(item);
            }
        });
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
