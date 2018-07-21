package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.data.model.CharacterSkills;

/**
 * Methods for accessing the database
 */

@Dao
public interface CharacterSkillsDao {
    @Query("SELECT * FROM character_stats WHERE character_id = :charId")
    LiveData<CharacterSkills> findStatsById(int charId);

    @Insert
    void insertStats(CharacterSkills characterSkills);

    @Update
    void updateStats(CharacterSkills characterSkills);
}
