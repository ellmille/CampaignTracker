package com.elle.campaigntracker.data.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.elle.campaigntracker.data.entity.LogEntity;
import com.elle.campaigntracker.data.entity.PlayableCharacterEntity;

/**
 * Methods for accessing the database
 */

public interface LogDao {
    @Query("SELECT * FROM logs WHERE char_id = :charId")
    LogEntity findLogsForCharacter(int charId);

    @Insert
    void insertLog(LogEntity log);
}
