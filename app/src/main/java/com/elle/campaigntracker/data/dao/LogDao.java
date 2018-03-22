package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.data.model.Log;

import java.util.List;

/**
 * Methods for accessing the database
 */

public interface LogDao {
    @Query("SELECT * FROM log WHERE character_id = :charId")
    LiveData<List<Log>> findLogsForCharacter(int charId);

    @Insert
    void insertLog(Log log);

    @Update
    void updateLog(Log log);

    @Delete
    void deleteLog(Log log);
}
