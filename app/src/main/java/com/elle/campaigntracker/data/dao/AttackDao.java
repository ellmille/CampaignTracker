package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.data.model.Attack;

import java.util.List;

/**
 * Methods for accessing the database
 */

@Dao
public interface AttackDao {
    @Query("SELECT * FROM attack WHERE character_id = :charId")
    LiveData<List<Attack>> findAttacksForCharacter(int charId);

    @Insert
    void insertAttack(Attack attack);

    @Update
    void updateAttack(Attack attack);

    @Delete
    void deleteAttack(Attack attack);
}
