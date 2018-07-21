package com.elle.campaigntracker.data;

import com.elle.campaigntracker.inventory.Item;
import com.elle.campaigntracker.data.model.CharacterInfo;
import com.elle.campaigntracker.character.PlayableCharacter;
import com.elle.campaigntracker.data.model.category.Alignment;
import com.elle.campaigntracker.data.model.CharacterSkills;
import com.elle.campaigntracker.data.model.category.RoleClass;

import java.util.ArrayList;
import java.util.List;

/**
 * PlayerCharacter sheet pre-sqlite setup
 */

public class DummyRepo {
    private static PlayableCharacter playableChar;

    DummyRepo(){
        playableChar = createPlayableChar();
    }

    private PlayableCharacter createPlayableChar() {
        PlayableCharacter playableChar = new PlayableCharacter("Rex", RoleClass.Role.ROGUE, Alignment.CHAOTIC_NEUTRAL);
        playableChar.setMaxHp(34);
        playableChar.setCurrentHp(34);
        playableChar.setLevel(4);
        playableChar.setTotalXpToLevel(6500);
        playableChar.setCurrentXp(1550);
        playableChar.setCharacterRace("Half-elf");
        return playableChar;
    }

    public static CharacterSkills createPlayableCharStats(int charId) {
        CharacterSkills stats = new CharacterSkills(charId);
        stats.setArmorClass(17);
        stats.setInitiative(5);
        stats.setSpeed(30);
        stats.setProficiencyBonus(3);
        //saving throws
        stats.setStrength(13);
        stats.setDexterity(20);
        stats.setConstitution(14);
        stats.setIntelligence(16);
        stats.setWisdom(13);
        stats.setCharisma(16);
        //skills
        stats.setAcrobatics(8);
        stats.setAnimalHandling(1);
        stats.setArcana(3);
        stats.setAthletics(1);
        stats.setDeception(5);
        stats.setHistory(3);
        stats.setInsight(3);
        stats.setIntimidation(6);
        stats.setInvestigation(9);
        stats.setMedicine(1);
        stats.setNature(3);
        stats.setPerception(3);
        stats.setPersuasion(3);
        stats.setReligion(3);
        stats.setSleightOfHand(8);
        stats.setStealth(11);
        stats.setSurvival(1);
        return stats;
    }

    public static CharacterInfo getPcInfo(int charId){
        CharacterInfo info = new CharacterInfo();
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
}
