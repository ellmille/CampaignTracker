package com.elle.campaigntracker.model;

import com.elle.campaigntracker.model.character.Alignment;
import com.elle.campaigntracker.model.turn.Attack;

import java.util.List;

/**
 * Interface for PlayableCharacterEntity
 */

public interface PlayableCharacter {
    int getId();
    String getName();
    String getCharacterClass();
    Alignment getAlignment();
    String getBackground();
    int getMaxHp();
    int getCurrentHp();
    int getLevel();
    int getTotalXpToLevel();
    int getCurrentXp();
    CharacterStats getCharacterStats();
}
