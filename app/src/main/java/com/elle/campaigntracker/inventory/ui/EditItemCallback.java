package com.elle.campaigntracker.inventory.ui;

import com.elle.campaigntracker.inventory.Item;

/**
 * Callback for adding/editing an item
 */

public interface EditItemCallback {
    void onSave(Item item);
    void onDelete(Item item);
}
