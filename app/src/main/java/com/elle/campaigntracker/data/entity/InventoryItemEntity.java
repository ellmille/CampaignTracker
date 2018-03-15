package com.elle.campaigntracker.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.elle.campaigntracker.model.character.InventoryItem;

/**
 * DB entry for inventory item
 */

@Entity(tableName = "inventory")
public class InventoryItemEntity implements InventoryItem {
    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private int price;
    private int character_id;

    public InventoryItemEntity(){

    }
    public InventoryItemEntity(int id, String name, String description, int price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public InventoryItemEntity(InventoryItem inventoryItem){
        this.id = inventoryItem.getId();
        this.name = inventoryItem.getName();
        this.description = inventoryItem.getDescription();
        this.price = inventoryItem.getPrice();
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }
}
