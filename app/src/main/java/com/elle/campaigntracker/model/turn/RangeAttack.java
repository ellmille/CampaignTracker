package com.elle.campaigntracker.model.turn;

/**
 * Ranged attack
 */

public class RangeAttack extends Attack {
    public RangeAttack(String name, int attackBonus, int rollCount, String rollType, int damage) {
        super(name, attackBonus, rollCount, rollType, damage);
    }
}