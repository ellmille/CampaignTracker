package com.elle.campaigntracker.data.repo;

import com.elle.campaigntracker.data.character.Alignment;
import com.elle.campaigntracker.data.character.Attack;
import com.elle.campaigntracker.data.character.Character;

/**
 * Character sheet pre-sqlite setup
 */

public class DummyRepo {
    public static Character getRex(){
        Character rex = new Character("Rex");
        rex.setPlayerClass("Rouge");
        rex.setAlignment(Alignment.CHAOTIC_NEUTRAL);
        Attack attack1 = new Attack("Short Sword, main hand", 8, 1, "D6", 6);
        rex.addAttackToList(attack1);
        Attack attack2 = new Attack("Short Sword, other hand", 7, 1, "D6", 0);
        rex.addAttackToList(attack2);
        Attack attack3 = new Attack("Short Bow", 7, 1, "D6", 5);
        rex.addAttackToList(attack3);
        rex.setMaxHp(34);
        rex.setCurrentHp(34);
        return rex;
    }
}
