package com.elle.campaigntracker.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.elle.campaigntracker.model.PlayableCharacter;
import com.elle.campaigntracker.model.character.Alignment;
import com.elle.campaigntracker.model.turn.Attack;

import java.util.List;

/**
 * entity for room db, implements Player Character Interface
 */

@Entity(tableName = "playable_characters")
public class PlayableCharacterEntity implements PlayableCharacter {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name, characterClass;
    private Alignment alignment;
    private int level;
    private int maxHp, currentHp;
    private int totalXpToLevel, currentXp;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass){
        this.characterClass = characterClass;
    }

    @Override
    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment){
        this.alignment = alignment;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp){
        this.maxHp = maxHp;
    }

    @Override
    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp){
        this.currentHp = currentHp;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    @Override
    public int getTotalXpToLevel() {
        return totalXpToLevel;
    }

    public void setTotalXpToLevel(int totalXpToLevel){
        this.totalXpToLevel = totalXpToLevel;
    }

    @Override
    public int getCurrentXp() {
        return currentXp;
    }

    public void setCurrentXp(int currentXp){
        this.currentXp = currentXp;
    }
}
