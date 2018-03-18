package com.elle.campaigntracker.data;

import com.elle.campaigntracker.data.entity.PlayableCharacterEntity;
import com.elle.campaigntracker.model.character.Alignment;
import com.elle.campaigntracker.model.character.PlayableChar;
import com.elle.campaigntracker.model.turn.Attack;

/**
 * PlayerCharacter sheet pre-sqlite setup
 */

public class DummyRepo {
    private static PlayableCharacterEntity rex;
    private static PlayableChar playableChar;

    public DummyRepo(){
        //rex = createRex();
        playableChar = createPlayableChar();
    }

    private PlayableChar createPlayableChar() {
        PlayableChar playableChar = new PlayableChar();
        playableChar.setName("Rex");
        playableChar.setCharacterClass("Rouge");
        playableChar.setAlignment(Alignment.CHAOTIC_NEUTRAL);
        playableChar.setMaxHp(34);
        playableChar.setCurrentHp(34);
        playableChar.setLevel(4);
        playableChar.setTotalXpToLevel(6500);
        playableChar.setCurrentXp(1550);
        return playableChar;
    }

    public PlayableChar getPlayableChar(){
        return playableChar;
    }

    private PlayableCharacterEntity createRex(){
        PlayableCharacterEntity rex = new PlayableCharacterEntity();
        rex.setName("Rex");
        rex.setCharacterClass("Rouge");
        rex.setAlignment(Alignment.CHAOTIC_NEUTRAL);
//        Attack attack1 = new Attack("Short Sword, main hand", 8, 1, "D6", 6);
//        rex.addAttackToList(attack1);
//        Attack attack2 = new Attack("Short Sword, other hand", 7, 1, "D6", 0);
//        rex.addAttackToList(attack2);
//        Attack attack3 = new Attack("Short Bow", 7, 1, "D6", 5);
//        rex.addAttackToList(attack3);
        rex.setMaxHp(34);
        rex.setCurrentHp(34);
        rex.setLevel(4);
        rex.setTotalXpToLevel(6500);
        rex.setCurrentXp(1550);
        return rex;
    }

    public static PlayableCharacterEntity getRex() {
        return rex;
    }
}
