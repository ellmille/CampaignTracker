package com.elle.campaigntracker.data;

import com.elle.campaigntracker.model.character.Alignment;
import com.elle.campaigntracker.model.turn.Attack;
import com.elle.campaigntracker.model.character.PlayerCharacter;

/**
 * PlayerCharacter sheet pre-sqlite setup
 */

public class DummyRepo {
    private static PlayerCharacter rex;

    public DummyRepo(){
        rex = createRex();
    }

    private PlayerCharacter createRex(){
        PlayerCharacter rex = new PlayerCharacter("Rex");
        rex.setCharacterClass("Rouge");
        rex.setAlignment(Alignment.CHAOTIC_NEUTRAL);
        Attack attack1 = new Attack("Short Sword, main hand", 8, 1, "D6", 6);
        rex.addAttackToList(attack1);
        Attack attack2 = new Attack("Short Sword, other hand", 7, 1, "D6", 0);
        rex.addAttackToList(attack2);
        Attack attack3 = new Attack("Short Bow", 7, 1, "D6", 5);
        rex.addAttackToList(attack3);
        rex.setMaxHp(34);
        rex.setCurrentHp(34);
        rex.setLevel(4);
        rex.setTotalXpToLevel(6500);
        rex.setCurrentXp(1550);
        return rex;
    }

    public static PlayerCharacter getRex() {
        return rex;
    }
}
