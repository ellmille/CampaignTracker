package com.elle.campaigntracker;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.elle.campaigntracker.data.AppDatabase;
import com.elle.campaigntracker.data.model.Attack;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.data.model.Log;
import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.data.model.PlayableCharacterStats;

import java.util.List;

/**
 * Handles working with the database
 */

public class Repo {
    private static Repo instance;

    private final AppDatabase database;
    private MediatorLiveData<PlayableCharacter> observableCharacter;
    private MediatorLiveData<PlayableCharacterStats> observableStats;
    private MediatorLiveData<List<Item>> observableInventory;
    private final int charId;

    private Repo(final AppDatabase database, int charId){
        this.database = database;
        this.charId = charId;
        this.observableCharacter = new MediatorLiveData<>();
        this.observableStats = new MediatorLiveData<>();
        this.observableInventory = new MediatorLiveData<>();

        observableCharacter.addSource(loadCharacter(charId), new Observer<PlayableCharacter>() {
            @Override
            public void onChanged(@Nullable PlayableCharacter playableCharacter) {
                observableCharacter.postValue(playableCharacter);
            }
        });

        observableStats.addSource(loadCharacterStats(charId), new Observer<PlayableCharacterStats>() {
            @Override
            public void onChanged(@Nullable PlayableCharacterStats playableCharacterStats) {
                observableStats.postValue(playableCharacterStats);
            }
        });

        observableInventory.addSource(loadItemsForCharacter(charId), new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                observableInventory.postValue(items);
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

    public LiveData<PlayableCharacterStats> getCharacterStats(){
        return observableStats;
    }

    public LiveData<List<Item>> getInventory(){
        return observableInventory;
    }

    public LiveData<PlayableCharacter> loadCharacter(final int charId){
        return database.playerCharacterDao().findCharacterById(charId);
    }

    public LiveData<PlayableCharacterStats> loadCharacterStats(final int charId){
        return database.playableCharacterStatsDao().findStatsById(charId);
    }

    public LiveData<List<Log>> loadLogsForCharacter(final int charId){
        return database.logDao().findLogsForCharacter(charId);
    }

    public LiveData<List<Item>> loadItemsForCharacter(final int charId){
        return database.itemDao().findInventoryForCharacter(charId);
    }

    public void addItemToInventory(Item item){
        database.addItem(item);
    }

    public LiveData<List<Attack>> loadAttacksForCharacter(final int charId){
        return database.attackDao().findAttacksForCharacter(charId);
    }

    public int getCharId() {
        return charId;
    }
}
