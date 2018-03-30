package com.elle.campaigntracker.data;

import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.data.model.category.Alignment;
import com.elle.campaigntracker.data.model.PcStats;

/**
 * PlayerCharacter sheet pre-sqlite setup
 */

public class DummyRepo {
    private static PlayableCharacter playableChar;
    private static PcStats stats;

    public DummyRepo(){
        playableChar = createPlayableChar();
        stats = createPlayableCharStats(playableChar.getId());
    }

    private PlayableCharacter createPlayableChar() {
        PlayableCharacter playableChar = new PlayableCharacter("Rex", "Rouge", Alignment.CHAOTIC_NEUTRAL);
        playableChar.setMaxHp(34);
        playableChar.setCurrentHp(34);
        playableChar.setLevel(4);
        playableChar.setTotalXpToLevel(6500);
        playableChar.setCurrentXp(1550);
        playableChar.setCharacterRace("Half-elf");
        return playableChar;
    }

    private PcStats createPlayableCharStats(int charId) {
        PcStats stats = new PcStats(charId);
        stats.setProficiencyBonus(2);

        return stats;
    }

    public PlayableCharacter getPlayableChar(){
        return playableChar;
    }

//        Attack attack1 = new Attack("Short Sword, main hand", 8, 1, "D6", 6);
//        rex.addAttackToList(attack1);
//        Attack attack2 = new Attack("Short Sword, other hand", 7, 1, "D6", 0);
//        rex.addAttackToList(attack2);
//        Attack attack3 = new Attack("Short Bow", 7, 1, "D6", 5);
//        rex.addAttackToList(attack3);

}
