package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.data.model.Item;

import java.util.List;

/**
 * Methods for accessing the database
 */

@Dao
public interface ItemDao {
    @Query("SELECT * FROM Item WHERE character_id = :charId")
    LiveData<List<Item>> findInventoryForCharacter(int charId);

    @Query("SELECT * FROM Item WHERE id = :id")
    LiveData<Item> findItemById(int id);

    @Query("SELECT DISTINCT name, description FROM Item")
    LiveData<List<Item>> findAllItems();

    @Insert
    void insertLog(Item item);

    @Update
    void updateLog(Item item);

    @Delete
    void deleteLog(Item item);
}
