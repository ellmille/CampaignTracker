package com.elle.campaigntracker.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.elle.campaigntracker.character.PlayableCharacter;

/**
 * POJO for features and traits
 */

@Entity(tableName = "traits", foreignKeys = @ForeignKey(entity = PlayableCharacter.class,
        parentColumns = "id",
        childColumns = "character_id"), indices = @Index(value = ("character_id")))
public class Traits {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "character_id")
    private int charId;
    private String trait, description;

    public int getId() {
        return id;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
