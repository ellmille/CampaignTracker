package com.elle.campaigntracker.data.model;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Tests for {@link Money}
 */
public class MoneyTest {

    @Test
    public void convertGoldToSilver_convert_ok() throws Exception {
        Money money = new Money(1, 10, 10, 10, 10, 10);
        int silver = money.convertGoldToSilver(money.getGold());
        Assert.assertEquals(silver, money.getGold() * 10);
    }

    @Test
    public void convertSilverToCopper() throws Exception {
    }

    @Test
    public void convertElectrumToSilver() throws Exception {
    }

    @Test
    public void convertPlatinumToGold() throws Exception {
    }

    @Test
    public void findWeight() throws Exception {
    }

}