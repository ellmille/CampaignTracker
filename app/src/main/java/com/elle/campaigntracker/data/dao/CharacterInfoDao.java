package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.data.model.CharacterInfo;

/**
 * Methods for accessing the database
 */

@Dao
public interface CharacterInfoDao {
    @Query("SELECT * FROM character_info WHERE character_id=:charId")
    LiveData<CharacterInfo> getInfoByCharId(int charId);

    @Insert
    void insertPcInfo(CharacterInfo characterInfo);

    @Update
    void updatePcInfo(CharacterInfo characterInfo);
}
