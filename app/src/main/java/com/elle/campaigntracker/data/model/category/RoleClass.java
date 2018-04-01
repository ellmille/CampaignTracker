package com.elle.campaigntracker.data.model.category;

/**
 * Base Model for class
 */

public class RoleClass {
    private final String name;
    private final Role role;
    private String description;

    public RoleClass(String name, Role roleName){
        this.name = name;
        this.role = roleName;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Role {
        BARBRIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE,
        SORCERER, WARLOCK, WIZARD, OTHER
    }
}
