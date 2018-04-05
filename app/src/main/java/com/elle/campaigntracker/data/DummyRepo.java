package com.elle.campaigntracker.data;

import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.data.model.PcInfo;
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

    public DummyRepo(){
        playableChar = createPlayableChar();
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

    public static PcStats createPlayableCharStats(int charId) {
        PcStats stats = new PcStats(charId);
        stats.setArmorClass(17);
        stats.setInitiative(5);
        stats.setSpeed(30);
        stats.setProficiencyBonus(2);
        //saving throws
        stats.setStrength(1);
        stats.setDexterity(7);
        stats.setConstitution(2);
        stats.setIntelligence(5);
        stats.setWisdom(1);
        stats.setCharisma(3);
        //skills
        stats.setAcrobatics(7);
        stats.setAnimalHandling(1);
        stats.setArcana(3);
        stats.setAthletics(1);
        stats.setDeception(5);
        stats.setHistory(3);
        stats.setInsight(3);
        stats.setIntimidation(5);
        stats.setInvestigation(7);
        stats.setMedicine(1);
        stats.setNature(3);
        stats.setPerception(3);
        stats.setPersuasion(3);
        stats.setReligion(3);
        stats.setSleightOfHand(7);
        stats.setStealth(9);
        stats.setSurvival(1);
        return stats;
    }

    public static PcInfo getPcInfo(int charId){
        PcInfo info = new PcInfo();
        info.setCharId(charId);
        info.setAge(20);
        info.setWeight(140);
        info.setEyes("Green");
        info.setHair("Blonde");
        return info;
    }

    public PlayableCharacter getPlayableChar(){
        return playableChar;
    }

    public static List<Item> getItemList(int charId){
        List<Item> returnList = new ArrayList<>();
        Item item = new Item(charId, "Rodney (Immovable Rod)", 1, "Totally dope rod with a button" +
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
        Item item5 = new Item(charId, "Bracer of Archer", 1, "Grants proficiency with long bow");
        returnList.add(item5);
        Item item6 = new Item(charId, "Potion of Healing", 1, "");
        item6.setCategory(Item.ItemCategory.HEALING);
        returnList.add(item6);
        Item item7 = new Item(charId, "Great Potion of Healing", 1, "");
        item7.setCategory(Item.ItemCategory.HEALING);
        returnList.add(item7);
        Item item8 = new Item(charId, "Superior Potions", 2, "");
        item8.setCategory(Item.ItemCategory.HEALING);
        returnList.add(item8);
        return returnList;
    }

//        Attack attack1 = new Attack("Short Sword, main hand", 8, 1, "D6", 6);
//        rex.addAttackToList(attack1);
//        Attack attack2 = new Attack("Short Sword, other hand", 7, 1, "D6", 0);
//        rex.addAttackToList(attack2);
//        Attack attack3 = new Attack("Short Bow", 7, 1, "D6", 5);
//        rex.addAttackToList(attack3);

}
