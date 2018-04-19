package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.data.model.world.Npc;

/**
 * Database access for Npcs
 */

@Dao
public interface NpcDao {
    @Query("SELECT * FROM non_playable_characters WHERE character_id=:charId")
    LiveData<Npc> getNpcByCharId(int charId);

    @Query("SELECT * FROM non_playable_characters")
    LiveData<Npc> fetchAllNpc();

    @Insert
    void insertNpc(Npc npc);

    @Update
    void updateNpc(Npc npc);
}
