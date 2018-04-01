package com.elle.campaigntracker.data.model.category;

/**
 * Base model for race
 */

public class RoleRace {
    private int id;
    private String name;
    private Race raceName;
    //ability score increases
    private Size size;
    private int speed;
    //age
    //languages
    //sub-races?
    //traits

    public enum Race {
        DWARF, ELF, HALFLING, HUMAN, DRAGONBORN, GNOME, HALF_ELF, HALF_ORC, TIEFLING,
        OTHER
    }

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    public class Languages {
        public final String COMMON = "Common";
        //dwarvish
        //elvish
        //giant
        //gnomish
        //goblin
        //halfling
        //orc
        //abyssal
        //celestial
        //deep speech
        //draconic
        //infernal
        //primordial
        //slyvian
        //undercommon
    }
}
