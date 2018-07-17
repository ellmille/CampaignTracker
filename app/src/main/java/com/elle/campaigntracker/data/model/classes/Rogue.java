package com.elle.campaigntracker.data.model.classes;

import com.elle.campaigntracker.data.model.category.Dice;
import com.elle.campaigntracker.data.model.category.RoleClass;

/**
 * POJO for Rogue
 */

public class Rogue extends RoleClass {
    private Archetype archetype;
    private boolean hasDexProf, hasIntProf;
    private boolean hasAcroProf, hasAthleticsProf, hasDeceptionProf, hasInsightProf
            , hasIntimidationProf, hasInvetProf, hasPerfceptionProf, hasPersuasionProf
            , hasSleightProf, hasStealthProf;

    public Rogue() {
        super(Role.ROGUE);
        this.setHitDie(Dice.D8);
        this.setHitDieCount(4);
        this.setDescription("Being a sneaky badass and taking names");
    }

    public void setArchetype(Archetype archetype){
        this.archetype = archetype;
    }

    public Archetype getArchetype(){
        return archetype;
    }

    public enum Archetype {
        THIEF, ASSASSIN, ARCANE_TRICKSTER
    }
}
