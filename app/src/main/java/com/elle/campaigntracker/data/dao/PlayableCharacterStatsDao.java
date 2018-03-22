package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.data.model.PlayableCharacterStats;

/**
 * Methods for accessing the database
 */

@Dao
public interface PlayableCharacterStatsDao {
    @Query("SELECT * FROM character_stats WHERE character_id = :charId")
    LiveData<PlayableCharacterStats> findStatsById(int charId);

    @Insert
    void insertStats(PlayableCharacterStats playableCharacterStats);

    @Update
    void updateStats(PlayableCharacterStats playableCharacterStats);
}
