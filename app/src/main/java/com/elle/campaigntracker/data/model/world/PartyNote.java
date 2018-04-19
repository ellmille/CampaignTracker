package com.elle.campaigntracker.data.model.world;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Table for notes on teammates
 */

@Entity(tableName = "party_notes", foreignKeys = @ForeignKey(entity = PartyMember.class,
        parentColumns = "id",
        childColumns = "foreign_id"), indices = @Index(value = ("foreign_id")))
public class PartyNote implements Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "foreign_id")
    private int foreignId;
    private String message;
    private long timeCreated;

    @Ignore
    public PartyNote(int fId, String message){
        this.foreignId = fId;
        this.message = message;
        this.timeCreated = System.currentTimeMillis();
    }

    public PartyNote(int id, int fId, String message, long timeCreated){
        this.id = id;
        this.foreignId = fId;
        this.message = message;
        this.timeCreated = timeCreated;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getForeignId() {
        return foreignId;
    }

    @Override
    public void setForeignId(int fId) {
        this.foreignId = fId;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public long getTimeCreated() {
        return timeCreated;
    }

    @Override
    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }
}
