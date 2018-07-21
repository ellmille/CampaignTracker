package com.elle.campaigntracker.inventory.ui;

/**
 * Callbacks for the inventory
 */

public interface InventoryCallback {
    interface MoneyCall {
        void onAdd();
        void onSpend();
    }
}
