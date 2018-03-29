package com.elle.campaigntracker.view.callback;

import com.elle.campaigntracker.data.model.Item;

/**
 * Callbacks for the inventory
 */

public interface InventoryCallback {
    interface MoneyCall {
        void onAdd();
        void onSpend();
    }
}
