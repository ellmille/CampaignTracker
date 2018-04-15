package com.elle.campaigntracker.view.callback;

/**
 * Callback for death saving throws
 */

public interface DeathSavingCallback {
    void onDeathSave(int retry);
    void onDeathFail(int retry);
}
