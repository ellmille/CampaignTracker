package com.elle.campaigntracker.data.repo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.data.character.PlayerCharacter;

import java.util.List;

/**
 * Methods for accessing the database
 */

@Dao
public interface PlayerCharacterDao {
    @Query("SELECT * FROM player_characters")
    List<PlayerCharacter> getAllCharacters();

    @Query("SELECT * FROM player_characters WHERE id = :id")
    PlayerCharacter findCharacterById(int id);

    @Query("SELECT * FROM player_characters WHERE name LIKE :name")
    PlayerCharacter findCharacterByName(String name);

    @Insert
    public void insertPlayerCharacter(PlayerCharacter playerCharacter);

    @Update
    public void updatePlayerCharacter(PlayerCharacter playerCharacter);
}
