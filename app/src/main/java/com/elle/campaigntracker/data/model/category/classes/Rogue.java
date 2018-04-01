package com.elle.campaigntracker.data.model.category.classes;

import com.elle.campaigntracker.data.model.category.RoleClass;

/**
 * POJO for Rogue
 */

public class Rogue extends RoleClass {
    private Archetype archetype;

    public Rogue() {
        super("Rogue", Role.ROGUE);
        this.setDescription("Being a sneaky badass and taking names");
    }

    public enum Archetype {
        THIEF, ASSASSIN, ARCANE_TRICKSTER
    }
}
