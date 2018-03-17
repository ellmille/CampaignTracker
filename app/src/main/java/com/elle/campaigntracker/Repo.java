package com.elle.campaigntracker;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.elle.campaigntracker.data.AppDatabase;
import com.elle.campaigntracker.data.entity.LogEntity;
import com.elle.campaigntracker.data.entity.PlayableCharacterEntity;
import com.elle.campaigntracker.model.PlayableCharacter;

/**
 * Handles working with the database
 */

public class Repo {
    private static Repo instance;

    private final AppDatabase database;
    private MediatorLiveData<PlayableCharacterEntity> observableCharacter;

    private Repo(final AppDatabase database, int charId){
        this.database = database;
        this.observableCharacter = new MediatorLiveData<>();

//        observableCharacter.addSource(database.playerCharacterDao().findCharacterById(charId),
//            playCharacterEntity -> {
//                if(database.getDatabaseCreated().getValue() != null){
//                    observableCharacter.postValue(playCharacterEntity);
//                }
//            });
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
    public LiveData<PlayableCharacterEntity> getCharacter(){
        return observableCharacter;
    }

    public PlayableCharacterEntity loadCharacter(final int charId){
        return database.playerCharacterDao().findCharacterById(charId);
    }

//    public LiveData<LogEntity> loadLogsForCharacter(final int charId){
//        return database.logDao().findLogsForCharacter(charId);
//    }
}
