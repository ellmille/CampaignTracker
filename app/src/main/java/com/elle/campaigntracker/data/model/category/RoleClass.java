package com.elle.campaigntracker.data.model.category;

import com.elle.campaigntracker.data.model.classes.Rogue;

/**
 * Base Model for class
 */

public class RoleClass {
    private final Role role;
    private int hitDieCount;
    private Dice hitDie;
    private String description;

    public RoleClass(Role roleName){
        this.role = roleName;
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

    public Dice getHitDie() {
        return hitDie;
    }

    public void setHitDie(Dice hitDie) {
        this.hitDie = hitDie;
    }

    public int getHitDieCount() {
        return hitDieCount;
    }

    public void setHitDieCount(int hitDieCount) {
        this.hitDieCount = hitDieCount;
    }

    public static RoleClass findClass(Role role){
        switch (role){
            case ROGUE:
                return new Rogue();
        }
        return new RoleClass(Role.OTHER);
    }

    public enum Role {
        BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE,
        SORCERER, WARLOCK, WIZARD, OTHER
    }
}
