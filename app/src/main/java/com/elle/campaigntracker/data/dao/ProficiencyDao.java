package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.data.model.Proficiency;

import java.util.List;

/**
 * Methods for accessing the database
 */

@Dao
public interface ProficiencyDao {
    @Query("SELECT * FROM proficiencies WHERE character_id=:charId")
    LiveData<List<Proficiency>> getProficienciesForChar(int charId);

    @Insert
    void insertProficiency(Proficiency proficiency);

    @Update
    void updateProficiency(Proficiency proficiency);
}
