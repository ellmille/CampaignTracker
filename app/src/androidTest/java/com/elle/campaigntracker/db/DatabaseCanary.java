package com.elle.campaigntracker.db;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.elle.campaigntracker.data.character.PlayerCharacter;
import com.elle.campaigntracker.data.repo.AppDatabase;
import com.elle.campaigntracker.data.repo.PlayerCharacterDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

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
        testDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        playerCharacterDao = testDatabase.playerCharacterDao();
    }

    @After
    public void closeDb() throws IOException {
        testDatabase.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        PlayerCharacter playerCharacter = new PlayerCharacter("test");

        playerCharacterDao.insertPlayerCharacter(playerCharacter);
        PlayerCharacter byName = playerCharacterDao.findCharacterByName("test");
        assertEquals(playerCharacter, byName);
    }
}
