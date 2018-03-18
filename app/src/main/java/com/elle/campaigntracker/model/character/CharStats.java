package com.elle.campaigntracker.model.character;

import com.elle.campaigntracker.model.CharacterStats;

/**
 * temp class for char stats
 */

public class CharStats implements CharacterStats {
    private int proficiencyBonus, strength, dexterity, constitution;
    private int intelligence, wisdom, charisma;
    private int acrobatics, animalHandling, arcana, athletics;
    private int deception, history, insight, intimidation, investigation;
    private int medicine, nature, perception, performance, persuassion;
    private int religion, sleightOfHand, stealth, survival;

    @Override
    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus){
        this.proficiencyBonus = proficiencyBonus;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity){
        this.dexterity = dexterity;
    }

    @Override
    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution){
        this.constitution = constitution;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }

    @Override
    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom){
        this.wisdom = wisdom;
    }

    @Override
    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma){
        this.charisma = charisma;
    }

    @Override
    public int getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(int acrobatics){
        this.acrobatics = acrobatics;
    }

    @Override
    public int getAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(int animalHandling){
        this.animalHandling = animalHandling;
    }

    @Override
    public int getArcana() {
        return arcana;
    }

    public void setArcana(int arcana){
        this.arcana = arcana;
    }

    @Override
    public int getAthletics() {
        return athletics;
    }

    public void setAthletics(int athletics){
        this.athletics = athletics;
    }

    @Override
    public int getDeception() {
        return deception;
    }

    public void setDeception(int deception){
        this.deception = deception;
    }

    @Override
    public int getHistory() {
        return history;
    }

    public void setHistory(int history){
        this.history = history;
    }

    @Override
    public int getInsight() {
        return insight;
    }

    public void setInsight(int insight){
        this.insight = insight;
    }

    @Override
    public int getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(int intimidation){
        this.intimidation = intimidation;
    }

    @Override
    public int getInvestigation() {
        return investigation;
    }

    public void setInvestigation(int investigation){
        this.investigation = investigation;
    }

    @Override
    public int getMedicine() {
        return medicine;
    }

    public void setMedicine(int medicine){
        this.medicine = medicine;
    }

    @Override
    public int getNature() {
        return nature;
    }

    public void setNature(int nature){
        this.nature = nature;
    }

    @Override
    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception){
        this.perception = perception;
    }

    @Override
    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance){
        this.performance = performance;
    }

    @Override
    public int getPersuasion() {
        return persuassion;
    }

    public void setPersuassion(int persuasion){
        this.persuassion = persuasion;
    }

    @Override
    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion){
        this.religion = religion;
    }

    @Override
    public int getSlightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(int sleightOfHand){
        this.sleightOfHand = sleightOfHand;
    }

    @Override
    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth){
        this.stealth = stealth;
    }

    @Override
    public int getSurvival() {
        return survival;
    }

    public void setSurvival(int survival){
        this.survival = survival;
    }
}
