package com.elle.campaigntracker.wallet;

import com.elle.campaigntracker.wallet.Money;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Tests for {@link Money}
 */
public class MoneyTest {
    @Test
    public void spendSilver_ok(){
        Money money = new Money(1, 10, 1, 10, 5, 1);
        money.spendSilver(1);
        Assert.assertEquals(0, money.getSilver());
    }

    @Test
    public void spendSilver_convertCopper_ok(){
        Money money = new Money(1, 10, 0, 10, 5, 1);
        money.spendSilver(1);
        Assert.assertEquals(0, money.getCopper());
        Assert.assertEquals(0, money.getSilver());
    }

    @Test
    public void spendSilver_convertGold_ok(){
        Money money = new Money(1, 10, 0, 0, 5, 1);
        money.spendSilver(1);
        Assert.assertEquals(9, money.getGold());
        Assert.assertEquals(9, money.getSilver());
    }

    @Test
    public void spendSilver_convertElectrum_ok(){
        Money money = new Money(1, 0, 0, 0, 5, 1);
        money.spendSilver(1);
        Assert.assertEquals(4, money.getElectrum());
        Assert.assertEquals(4, money.getSilver());
    }

    @Test
    public void spendSilver_convertPlatinum_ok(){
        Money money = new Money(1, 0, 0, 0, 0, 1);
        money.spendSilver(1);
        Assert.assertEquals(0, money.getPlatinum());
        Assert.assertEquals(9, money.getSilver());
        Assert.assertEquals(9, money.getGold());
    }

    @Test
    public void findWeight() throws Exception {
        Money money = new Money(1, 3, 3, 3, 3, 3);
        double weight = money.findWeight();
        Assert.assertEquals(5.0, weight);
    }

}