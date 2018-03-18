package com.elle.campaigntracker;

import android.app.Application;

import com.elle.campaigntracker.data.AppDatabase;

/**
 * Android Application class.
 */

public class App extends Application {
    private AppExecutors appExecutors;
    private int charId;

    @Override
    public void onCreate(){
        super.onCreate();
        appExecutors = new AppExecutors();
        charId = new LastSession(getApplicationContext()).getCharId();
    }

    public AppDatabase getDatabase(){
        return AppDatabase.getInstance(this, appExecutors);
    }

    public Repo getRepo(){
        return Repo.getInstance(getDatabase(), charId);
    }
}
