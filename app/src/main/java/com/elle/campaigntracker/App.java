package com.elle.campaigntracker;

import android.app.Application;

import com.elle.campaigntracker.data.AppDatabase;

/**
 * Android Application class.
 */

public class App extends Application {
    private AppExecutors appExecutors;

    @Override
    public void onCreate(){
        super.onCreate();
        appExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase(){
        return AppDatabase.getInstance(this, appExecutors);
    }

    public Repo getRepo(){
        return Repo.getInstance(getDatabase());
    }
}
