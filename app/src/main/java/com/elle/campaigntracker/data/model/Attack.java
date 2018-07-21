package com.elle.campaigntracker.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.elle.campaigntracker.character.PlayableCharacter;
import com.elle.campaigntracker.data.model.category.Dice;

/**
 * Represents an attack
 */

@Entity(foreignKeys = @ForeignKey(entity = PlayableCharacter.class,
        parentColumns = "id",
        childColumns = "character_id"), indices = @Index(value = ("character_id")))
public class Attack {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "character_id")
    private int charId;
    private String name;
    private int attackBonus;
    //damage
    private int rollCount;
    private Dice dice;
    private int damage;
    private String damageType;
    private int range;

    public Attack(String name, int attackBonus, int rollCount, Dice dice, int damage){
        this.name = name;
        this.attackBonus = attackBonus;
        this.rollCount = rollCount;
        this.dice = dice;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getRollCount() {
        return rollCount;
    }

    public void setRollCount(int rollCount) {
        this.rollCount = rollCount;
    }

    public Dice getDice(){
        return dice;
    }

    public void setDice(Dice dice){
        this.dice = dice;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
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
}
