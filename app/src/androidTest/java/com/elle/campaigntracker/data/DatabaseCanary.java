package com.elle.campaigntracker.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.elle.campaigntracker.LiveDataTestUtil;
import com.elle.campaigntracker.data.dao.PlayerCharacterDao;
import com.elle.campaigntracker.data.model.PlayableCharacter;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * Simple Read/Write tests
 */

@RunWith(AndroidJUnit4.class)
public class DatabaseCanary {
    private PlayerCharacterDao playerCharacterDao;
    private AppDatabase testDatabase;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        testDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .allowMainThreadQueries()
                .build();
        playerCharacterDao = testDatabase.playerCharacterDao();
    }

    @After
    public void closeDb() throws IOException {
        testDatabase.close();
    }

//    @Test
//    public void getCharacterWhenNoneInserted() throws InterruptedException {
//        List<PlayableCharacter> playableCharacters = LiveDataTestUtil.getValue(playerCharacterDao.getAllCharacters());
//        Assert.assertTrue(playableCharacters.isEmpty());
//    }

    @Test
    public void getInsertedCharacter() throws InterruptedException {
        DummyRepo dummyRepo = new DummyRepo();
        playerCharacterDao.insertPlayerCharacter(dummyRepo.getPlayableChar());

        PlayableCharacter playableCharacter = LiveDataTestUtil.getValue(playerCharacterDao.findCharacterById(1));

        Assert.assertNotNull(playableCharacter);
        Assert.assertEquals(dummyRepo.getPlayableChar().getName(), playableCharacter.getName());
    }
}
