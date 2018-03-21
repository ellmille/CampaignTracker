package com.elle.campaigntracker.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * POJO for playable character
 */

@Entity(tableName = "playable_characters")
public class PlayableCharacter {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name, characterClass;
    private Alignment alignment;
    private String background;
    private int level;
    private int maxHp, currentHp;
    private int totalXpToLevel, currentXp;
    private int proficiencyBonus, strength, dexterity, constitution;
    private int intelligence, wisdom, charisma;
    private int acrobatics, animalHandling, arcana, athletics;
    private int deception, history, insight, intimidation, investigation;
    private int medicine, nature, perception, performance, persuasion;
    private int religion, sleightOfHand, stealth, survival;

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

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
    // private CharacterStats characterStats;
}
