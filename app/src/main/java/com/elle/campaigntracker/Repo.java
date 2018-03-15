package com.elle.campaigntracker;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import com.elle.campaigntracker.data.AppDatabase;
import com.elle.campaigntracker.data.entity.InventoryItemEntity;
import com.elle.campaigntracker.data.entity.PlayCharacterEntity;

import java.util.List;

/**
 * Handles working with the database
 */

public class Repo {
    private static Repo instance;

    private final AppDatabase database;
    private MediatorLiveData<PlayCharacterEntity> observableCharacter;

    private Repo(final AppDatabase database){
        this.database = database;
        this.observableCharacter = new MediatorLiveData<>();
    }

    public static Repo getInstance(final AppDatabase database){
        if(instance == null){
            synchronized (Repo.class){
                if(instance == null){
                    instance = new Repo(database);
                }
            }
        }
        return instance;
    }

    /**
     * Get the list of products from the database and get notified when the data changes.
     */
    public LiveData<PlayCharacterEntity> getCharacter(){
        return observableCharacter;
    }

    public LiveData<List<InventoryItemEntity>> getItems(final int char_id){
        return database.inventoryDao().getItems(char_id);
    }
}
