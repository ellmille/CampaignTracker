package com.elle.campaigntracker.view.callback;

/**
 * Handles changing HP
 */

public interface HealthCallback {
    void heal(String hp);
    void takeDamage(String hp);
}
