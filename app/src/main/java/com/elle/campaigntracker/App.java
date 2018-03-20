package com.elle.campaigntracker;

import android.app.Application;

import com.elle.campaigntracker.data.AppDatabase;

import java.lang.reflect.Executable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Android Application class.
 */

public class App extends Application {
    private Executor executor;
    private int charId;

    @Override
    public void onCreate(){
        super.onCreate();
        executor = Executors.newFixedThreadPool(3);
        charId = new LastSession(getApplicationContext()).getCharId();
    }

    public int getCharId(){
        return charId;
    }

    public AppDatabase getDatabase(){
        return AppDatabase.getInstance(this, executor);
    }

    public Repo getRepo(){
        return Repo.getInstance(getDatabase(), charId);
    }
}
