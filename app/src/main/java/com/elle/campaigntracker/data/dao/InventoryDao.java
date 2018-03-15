package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.elle.campaigntracker.data.entity.InventoryItemEntity;

import java.util.List;

/**
 * Methods for accessing the database
 */

public interface InventoryDao {
    @Query("SELECT * FROM inventory")
    LiveData<List<InventoryItemEntity>> getAllItems();

    @Query("SELECT * FROM inventory WHERE character_id= :char_id")
    LiveData<List<InventoryItemEntity>> getItems(int char_id);

    @Query("select * from inventory where character_id = :char_id")
    List<InventoryItemEntity> getItemsSync(int char_id);

    @Query("select * from inventory where id = :id")
    InventoryItemEntity getItemSync(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<InventoryItemEntity> inventoryItems);
}
