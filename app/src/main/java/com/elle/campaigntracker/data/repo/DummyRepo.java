package com.elle.campaigntracker.data.repo;

import com.elle.campaigntracker.data.Alignment;
import com.elle.campaigntracker.data.Attack;

/**
 * Character sheet pre-sqlite setup
 */

public class DummyRepo {
    public static com.elle.campaigntracker.data.Character getRex(){
        com.elle.campaigntracker.data.Character rex = new com.elle.campaigntracker.data.Character("Rex");
        rex.setPlayerClass("Rouge");
        rex.setAlignment(Alignment.CHAOTIC_NEUTRAL);
        Attack attack1 = new Attack("Short Sword, main hand", 8, 1, "D6", 6);
        rex.addAttackToList(attack1);
        Attack attack2 = new Attack("Short Sword, other hand", 7, 1, "D6", 0);
        rex.addAttackToList(attack2);
        Attack attack3 = new Attack("Short Bow", 7, 1, "D6", 5);
        rex.addAttackToList(attack3);
        return rex;
    }
}
