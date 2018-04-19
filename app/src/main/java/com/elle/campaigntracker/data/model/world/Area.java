package com.elle.campaigntracker.data.model.world;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * POJO for an geographical area
 */

@Entity(tableName = "area")
public class Area {
    @PrimaryKey(autoGenerate = true)
    private int id;

}
