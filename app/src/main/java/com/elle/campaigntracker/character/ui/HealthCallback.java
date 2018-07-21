package com.elle.campaigntracker.character.ui;

/**
 * Handles changing HP
 */

public interface HealthCallback {
    void heal(String hp);
    void takeDamage(String hp);
}
