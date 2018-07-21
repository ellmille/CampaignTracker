package com.elle.campaigntracker.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.elle.campaigntracker.character.PlayableCharacter;

/**
 * POJO for proficiencies & languages
 */

@Entity(tableName = "proficiencies", foreignKeys = @ForeignKey(entity = PlayableCharacter.class,
        parentColumns = "id",
        childColumns = "character_id"), indices = @Index(value = ("character_id")))
public class Proficiency {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "character_id")
    private int charId;
    private String ability, description;

    public Proficiency(int id, int charId, String ability, String description){
        this.id = id;
        this.charId = charId;
        this.ability = ability;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getCharId() {
        return charId;
    }

    private void setCharId(int charId){
        this.charId = charId;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
