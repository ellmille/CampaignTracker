package com.elle.campaigntracker.data;

/**
 * Represents an attack
 */

public class Attack {
    private String name;
    private int attackBonus;
    //damage
    private int rollCount;
    private String rollType;
    private int damage;
    private String damageType;
    private int range;

    public Attack(String name, int attackBonus, int rollCount, String rollType, int damage){
        this.name = name;
        this.attackBonus = attackBonus;
        this.rollCount = rollCount;
        this.rollType = rollType;
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

    public String getRollType() {
        return rollType;
    }

    public void setRollType(String rollType) {
        this.rollType = rollType;
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
}
