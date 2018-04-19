package com.elle.campaigntracker.data.model.world;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * POJO for a city
 */

@Entity(tableName = "city", foreignKeys = @ForeignKey(entity = Area.class,
        parentColumns = "id",
        childColumns = "area_id"), indices = @Index(value = ("area_id")))
public class City {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "area_id")
    private int areaId;
    private String name;
}
