package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.data.model.PcInfo;

/**
 * Methods for accessing the database
 */

@Dao
public interface PcInfoDao {
    @Query("SELECT * FROM PcInfo WHERE character_id=:charId")
    LiveData<PcInfo> getInfoByCharId(int charId);

    @Insert
    void insertPcInfo(PcInfo pcInfo);

    @Update
    void updatePcInfo(PcInfo pcInfo);
}
