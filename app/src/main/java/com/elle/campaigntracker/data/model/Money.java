package com.elle.campaigntracker.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * POJO for characters money
 */

@Entity(tableName = "money", foreignKeys = @ForeignKey(entity = PlayableCharacter.class,
        parentColumns = "id",
        childColumns = "character_id"), indices = @Index(value = ("character_id")))
public class Money {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "character_id")
    private int charId;
    private int gold, silver, copper;
    private int electrum, platinum;
    @Ignore
    private final double weight = 1/3; // 1/3 of an oz.

    //    1 gold = 10 silver, 1 silver = 10 copper, 1 electrum = 5 silver, 1 platinum = 10 gold
    @Ignore
    private final int goldSilver = 10, silverCopper = 10, platinumGold = 10, electrumSilver = 5, goldElectrum = 2;

    @Ignore
    public Money(int charId, int gold, int silver, int copper, int electrum, int platinum){
        this.charId = charId;
        this.gold = gold;
        this.silver = silver;
        this.copper = copper;
        this.electrum = electrum;
        this.platinum = platinum;
    }

    public Money(int id, int charId, int gold, int silver, int copper, int electrum, int platinum){
        this.id = id;
        this.charId = charId;
        this.gold = gold;
        this.silver = silver;
        this.copper = copper;
        this.electrum = electrum;
        this.platinum = platinum;
    }

    public int getId() {
        return id;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getCopper() {
        return copper;
    }

    public void setCopper(int copper) {
        this.copper = copper;
    }

    public int getElectrum() {
        return electrum;
    }

    public void setElectrum(int electrum) {
        this.electrum = electrum;
    }

    public int getPlatinum() {
        return platinum;
    }

    public void setPlatinum(int platinum) {
        this.platinum = platinum;
    }

    //each coin weighs about 1/3 of an oz. (50 coins = 1 lb)
    public double findWeight(){
        int totalCoins = gold + silver + copper + electrum + platinum;
        if((totalCoins % 3) == 0){
            return totalCoins/3;
        }
        return totalCoins * weight;
    }

    public void updateGold(int amount, boolean isSpending){
        if(isSpending){
            spendGold(amount);
        }else{
            setGold(gold + amount);
        }
    }

    public void updateSilver(int amount, boolean isSpending){
        if(isSpending){
            spendSilver(amount);
        }else{
            setSilver(silver + amount);
        }
    }

    public void updateCopper(int amount, boolean isSpending){
        if(isSpending){
            spendCopper(amount);
        }else{
            setCopper(copper + amount);
        }
    }

    public void updateElectrum(int amount, boolean isSpending){
        if(isSpending){
            spendElectrum(amount);
        }else{
            setElectrum(electrum + amount);
        }
    }

    public void updatePlatinum(int amount, boolean isSpending){
        if(isSpending){
            spendPlatinum(amount);
        }else{
            setPlatinum(platinum + amount);
        }
    }

    void spendGold(int amount) {
        if (gold > amount) {
            setGold(gold - amount);
            return;
        }
        if (electrum < (goldElectrum) && platinum == 0 && copper < (silverCopper * goldSilver) && silver < goldSilver) {
            return;
        }
        if ((electrum / goldElectrum) + (copper / (silverCopper * goldSilver)) + (silver / goldSilver) +
                (platinum * platinumGold) + gold > amount) {
            while(gold < amount){
                if(copper >= (silverCopper * goldSilver)){
                    setGold(gold + 1);
                    setCopper(copper - (silverCopper * goldSilver));
                    break;
                }
                if(silver >= goldSilver){
                    setGold(gold + 1);
                    setSilver(silver - goldSilver);
                    break;
                }
                if(electrum >= goldElectrum){
                    setGold(gold + 1);
                    setElectrum(electrum - goldElectrum);
                    break;
                }
                if(platinum > 0){
                    setGold(gold + platinumGold);
                    setPlatinum(platinum - 1);
                }
            }
            setGold(gold - amount);
        }
    }

    void spendSilver(int amount){
        if(silver >= amount){
            setSilver(silver - amount);
            return;
        }
        if(electrum == 0 && platinum == 0 && copper < silverCopper && gold == 0){
            return;
        }
        if((gold * goldSilver) + (electrum * electrumSilver) + (copper / silverCopper) + (platinum * platinumGold * goldSilver) + silver> amount){
            while (silver < amount){
                //convert copper to silver
                if(copper >= silverCopper){
                    setSilver(silver + 1);
                    setCopper(copper - silverCopper);
                    continue;
                }
                //convert gold to silver
                if(gold > 0){
                    setSilver(silver + goldSilver);
                    setGold(gold - 1);
                    continue;
                }
                if(electrum > 0){
                    setSilver(silver + electrumSilver);
                    setElectrum(electrum - 1);
                    continue;
                }
                if(platinum > 0){
                    setGold(gold + platinumGold);
                    setPlatinum(platinum - 1);
                }
            }
            setSilver(silver - amount);
        }
    }

    public void spendCopper(int amount){
        if(copper > amount){
            setCopper(copper - amount);
            return;
        }
        if(electrum == 0 && platinum == 0 && silver == 0 && gold == 0){
            return;
        }
        if((gold * goldSilver * silverCopper) + (electrum * electrumSilver * silverCopper) +
                (platinum * platinumGold * goldSilver * silverCopper) + copper> amount){
            while(copper < amount){
                if(silver > 0){
                    setCopper(copper + silverCopper);
                    setSilver(silver - 1);
                    continue;
                }
                if(gold > 0){
                    setSilver(silver + goldSilver);
                    setGold(gold - 1);
                    continue;
                }
                if(electrum > 0){
                    setSilver(silver + electrumSilver);
                    setElectrum(electrum - 1);
                    continue;
                }
                if(platinum > 0){
                    setGold(gold + platinumGold);
                    setPlatinum(platinum - 1);
                }
            }
            setCopper(copper - amount);
        }
    }

    public void spendElectrum(int amount){
        if(electrum > amount){
            setElectrum(electrum - amount);
            return;
        }
        if(silver == 0 && platinum == 0 && copper == 0 && gold == 0){
            return;
        }
        if(gold * goldElectrum + (platinum * (platinumGold * goldElectrum)) + (silver / electrumSilver) +
                (copper / (silverCopper * electrumSilver)) >= amount){
            while(electrum < amount){
                if(silver >= electrumSilver){
                    setSilver(silver - electrumSilver);
                    setElectrum(electrum + 1);
                    continue;
                }
                if(copper >= electrumSilver * silverCopper){
                    setCopper(copper - (electrumSilver * silverCopper));
                    setElectrum(electrum + 1);
                    continue;
                }
                if(gold > 0){
                    setGold(gold - 1);
                    setElectrum(electrum + goldElectrum);
                    continue;
                }
                if(platinum > 0){
                    setPlatinum(platinum - 1);
                    setGold(gold + platinumGold);
                }
            }
            setElectrum(electrum - amount);
        }
    }

    public void spendPlatinum(int amount){
        if(platinum > amount){
            setPlatinum(platinum - amount);
            return;
        }
        if(electrum == 0 && silver == 0 && copper == 0 && gold == 0){
            return;
        }
        if ((gold / platinumGold) + (copper / (silverCopper * goldSilver * platinumGold)) + (silver / (goldSilver * platinumGold)) +
                (electrum / (goldElectrum * platinumGold)) + platinum > amount) {
            while (platinum < amount){
                if(copper >= (silverCopper * goldSilver * platinumGold)){
                    setCopper(copper - (silverCopper * goldSilver * platinumGold));
                    setPlatinum(platinum + 1);
                    continue;
                }
                if(silver >= (goldSilver * platinumGold)){
                    setSilver(silver - (goldSilver * platinumGold));
                    setPlatinum(platinum + 1);
                    continue;
                }
                if(gold >= platinumGold){
                    setGold(gold - platinumGold);
                    setPlatinum(platinum + 1);
                    continue;
                }
                if(electrum >= (goldElectrum * platinumGold)){
                    setElectrum(electrum - (goldElectrum * platinumGold));
                    setPlatinum(platinum + 1);
                }
            }
            setPlatinum(platinum - amount);
        }
    }
}
