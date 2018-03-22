package com.elle.campaigntracker.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * POJO for a log
 */

@Entity(foreignKeys = @ForeignKey(entity = PlayableCharacter.class,
        parentColumns = "id",
        childColumns = "character_id"), indices = @Index(value = ("character_id")))
public class Log {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "character_id")
    private int charId;
    private String title, logEntry;
    private long timeEntered;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogEntry() {
        return logEntry;
    }

    public void setLogEntry(String logEntry) {
        this.logEntry = logEntry;
    }

    public long getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(long timeEntered) {
        this.timeEntered = timeEntered;
    }
}
