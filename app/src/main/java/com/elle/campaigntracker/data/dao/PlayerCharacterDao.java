package com.elle.campaigntracker.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.data.entity.PlayableCharacterEntity;

import java.util.List;

/**
 * Methods for accessing the database
 */

@Dao
public interface PlayerCharacterDao {
    @Query("SELECT * FROM player_characters")
    List<PlayableCharacterEntity> getAllCharacters();

    @Query("SELECT * FROM player_characters WHERE id = :id")
    PlayableCharacterEntity findCharacterById(int id);

    @Query("SELECT * FROM player_characters WHERE name LIKE :name")
    PlayableCharacterEntity findCharacterByName(String name);

    @Insert
    public void insertPlayerCharacter(PlayableCharacterEntity playerCharacter);

    @Update
    public void updatePlayerCharacter(PlayableCharacterEntity playerCharacter);
}
