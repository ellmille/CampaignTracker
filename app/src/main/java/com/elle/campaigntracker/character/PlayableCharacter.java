package com.elle.campaigntracker.character;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.elle.campaigntracker.data.model.category.Alignment;
import com.elle.campaigntracker.data.model.category.RoleClass;

/**
 * POJO for playable character
 */

@Entity(tableName = "playable_character")
public class PlayableCharacter {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name, characterClass, characterRace, background;
    private RoleClass.Role pcClass;
    //secondary class
    private Alignment alignment;
    private int level;
    private int maxHp, currentHp;
    private int totalXpToLevel, currentXp;

    @Ignore
    public PlayableCharacter(){

    }

    @Ignore
    public PlayableCharacter(String name, RoleClass.Role pcClass, Alignment alignment){
        this.name = name;
        this.pcClass = pcClass;
        this.alignment = alignment;
    }

    public PlayableCharacter(int id, String name, RoleClass.Role pcClass, String characterRace, Alignment alignment, int level, int maxHp, int currentHp,
                             int totalXpToLevel, int currentXp, String background){
        this.id = id;
        this.name = name;
        this.pcClass = pcClass;
        this.characterRace = characterRace;
        this.alignment = alignment;
        this.level = level;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.totalXpToLevel = totalXpToLevel;
        this.currentXp = currentXp;
        this.background = background;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getTotalXpToLevel() {
        return totalXpToLevel;
    }

    public void setTotalXpToLevel(int totalXpToLevel) {
        this.totalXpToLevel = totalXpToLevel;
    }

    public int getCurrentXp() {
        return currentXp;
    }

    public void setCurrentXp(int currentXp) {
        this.currentXp = currentXp;
    }

    public String getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(String characterRace) {
        this.characterRace = characterRace;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public RoleClass.Role getPcClass() {
        return pcClass;
    }

    public void setPcClass(RoleClass.Role pcClass) {
        this.pcClass = pcClass;
    }
}
