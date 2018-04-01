package com.elle.campaigntracker.data.model.category;

/**
 * Base Model for class
 */

public class RoleClass {
    private final String name;
    private final Role role;
    private final String description;
    private Archetype archetype;
    private String primaryAbility;

    public RoleClass(String name, Role roleName, String description){
        this.name = name;
        this.role = roleName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public enum Role {
        BARBRIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE,
        SORCERER, WARLOCK, WIZARD, OTHER
    }

    public enum Archetype {
        THIEF, ASSASSIN, ARCANE_TRICKSTER
    }
}
