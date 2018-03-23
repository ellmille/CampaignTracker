package com.elle.campaigntracker.view.callback;

/**
 * Handles changing HP
 */

public interface HealthCallback {
    void heal(int hp);
    void takeDamage(int hp);
}
