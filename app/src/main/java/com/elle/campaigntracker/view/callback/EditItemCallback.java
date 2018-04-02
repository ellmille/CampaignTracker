package com.elle.campaigntracker.view.callback;

import com.elle.campaigntracker.data.model.Item;

/**
 * Callback for adding/editing an item
 */

public interface EditItemCallback {
    void onSave(Item item);
    void onDelete(Item item);
}
