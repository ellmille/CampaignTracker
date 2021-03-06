package com.elle.campaigntracker.inventory;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.elle.campaigntracker.character.PlayableCharacter;

/**
 * POJO for an item in inventory
 */

@Entity(foreignKeys = @ForeignKey(entity = PlayableCharacter.class,
        parentColumns = "id",
        childColumns = "character_id"), indices = @Index(value = ("character_id")))
public class Item {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "character_id")
    private int charId;
    private String name;
    private int quantity;
    private String description;
    //defaults
    private ItemCategory category = ItemCategory.OTHER;
    private boolean isFavorite = false;

    @Ignore
    public Item(){
    }

    @Ignore
    public Item(int charId, String name, int quantity, String description){
        this.charId = charId;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
    }

    public Item(int id, int charId, String name, int quantity, String description){
        this.id = id;
        this.charId = charId;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public enum ItemCategory {
        WEAPON, APPAREL, HEALING, OTHER
    }
}
