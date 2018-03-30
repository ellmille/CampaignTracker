package com.elle.campaigntracker.data.model;

import com.elle.campaigntracker.data.model.category.Alignment;

/**
 * POJO for Non playable characters (or just other characters that you are not)
 */

public class Npc {
    private int id;
    private int charId;
    private String name, characterClass;
    private Alignment alignment;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }
}
