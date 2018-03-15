package com.elle.campaigntracker.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.elle.campaigntracker.model.Log;
import com.elle.campaigntracker.model.PlayableCharacter;

/**
 * DB
 */
@Entity(tableName = "logs",
        foreignKeys = @ForeignKey(entity = PlayableCharacterEntity.class,
        parentColumns = "id",
        childColumns = "char_id"))
public class LogEntity implements Log {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "char_id")
    private int charId;
    private String title, logEntry;
    private long timeEntered;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String getLogEntry() {
        return logEntry;
    }

    public void setLogEntry(String logEntry){
        this.logEntry = logEntry;
    }

    @Override
    public long getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(long timeEntered){
        this.timeEntered = timeEntered;
    }
}
