package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.data.model.PlayableCharacter;

import java.util.List;

/**
 * Methods for accessing the database
 */

@Dao
public interface PlayerCharacterDao {
    @Query("SELECT * FROM playable_character")
    List<PlayableCharacter> getAllCharacters();

    @Query("SELECT * FROM playable_character WHERE id = :id")
    LiveData<PlayableCharacter> findCharacterById(int id);

    @Query("SELECT * FROM playable_character WHERE name LIKE :name")
    PlayableCharacter findCharacterByName(String name);

    @Insert
    long insertPlayerCharacter(PlayableCharacter playerCharacter);

    @Update
    public void updatePlayerCharacter(PlayableCharacter playerCharacter);
}
