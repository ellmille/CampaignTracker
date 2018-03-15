package com.elle.campaigntracker.model.character;

/**
 * Represents player inventory-item
 */

public interface InventoryItem {
    int getId();
    String getName();
    String getDescription();
    int getPrice();
}
