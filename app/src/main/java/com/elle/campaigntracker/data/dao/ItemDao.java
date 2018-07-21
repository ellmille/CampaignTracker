package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.inventory.Item;

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

    @Query("SELECT DISTINCT * FROM Item")
    LiveData<List<Item>> findAllItems();

    @Insert
    void insertItem(Item item);

    @Insert
    void insertItemList(List<Item> itemList);

    @Update
    void updateItem(Item item);

    @Delete
    void deleteItem(Item item);
}
