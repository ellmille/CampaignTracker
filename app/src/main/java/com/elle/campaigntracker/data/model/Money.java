package com.elle.campaigntracker.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * POJO for characters money
 */

@Entity(tableName = "money", foreignKeys = @ForeignKey(entity = PlayableCharacter.class,
        parentColumns = "id",
        childColumns = "character_id"), indices = @Index(value = ("character_id")))
public class Money {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "character_id")
    private int charId;
    private int gold, silver, copper;
    private int electrum, platinum;

    @Ignore
    public Money(int charId, int gold, int silver, int copper, int electrum, int platinum){
        this.charId = charId;
        this.gold = gold;
        this.silver = silver;
        this.copper = copper;
        this.electrum = electrum;
        this.platinum = platinum;
    }

    public Money(int id, int charId, int gold, int silver, int copper, int electrum, int platinum){
        this.id = id;
        this.charId = charId;
        this.gold = gold;
        this.silver = silver;
        this.copper = copper;
        this.electrum = electrum;
        this.platinum = platinum;
    }

    public int getId() {
        return id;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getCopper() {
        return copper;
    }

    public void setCopper(int copper) {
        this.copper = copper;
    }

    public int getElectrum() {
        return electrum;
    }

    public void setElectrum(int electrum) {
        this.electrum = electrum;
    }

    public int getPlatinum() {
        return platinum;
    }

    public void setPlatinum(int platinum) {
        this.platinum = platinum;
    }

    //todo: conversions
//    1 gold = 10 silver
//    1 silver = 10 copper
//    1 electrum = 5 silver
//    1 platinum = 10 gold
    //each coin weighs about 1/3 of an oz. (50 coins = 1 lb)
}
