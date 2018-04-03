package com.elle.campaigntracker.data;

import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.data.model.category.Alignment;
import com.elle.campaigntracker.data.model.PcStats;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Item> getItemList(int charId){
        List<Item> returnList = new ArrayList<>();
        Item item = new Item(charId, "Immovable Rod", 1, "Totally dope rod with a button" +
                " that'll stick to any surface Mojlnir style");
        item.setFavorite(true);
        returnList.add(item);
        Item item1 = new Item(charId, "Potions of Heroism", 6, "Gain a temporary 10 hp," +
                " Add a D4 to any attack roll or saving throw");
        item1.setCategory(Item.ItemCategory.HEALING);
        returnList.add(item1);
        Item item2 = new Item(charId, "Poisoners tools", 1, "");
        returnList.add(item2);
        Item item3 = new Item(charId, "Thieves tools", 1, "");
        returnList.add(item3);
        Item item4 = new Item(charId, "Disguise Kit", 1, "");
        returnList.add(item4);
        Item item5 = new Item(charId, "Archery Bracer", 1, "Grants proficiency with long bow");
        returnList.add(item5);
        return returnList;
    }

//        Attack attack1 = new Attack("Short Sword, main hand", 8, 1, "D6", 6);
//        rex.addAttackToList(attack1);
//        Attack attack2 = new Attack("Short Sword, other hand", 7, 1, "D6", 0);
//        rex.addAttackToList(attack2);
//        Attack attack3 = new Attack("Short Bow", 7, 1, "D6", 5);
//        rex.addAttackToList(attack3);

}
