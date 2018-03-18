package com.elle.campaigntracker.model.character;

import com.elle.campaigntracker.model.Log;

/**
 * Temp log class
 */

public class AdLog implements Log {
    private int id;
    private String title, logEntry;
    private long timeEntered;

    public AdLog(String title, String logEntry){
        this.title = title;
        this.logEntry = logEntry;
        this.timeEntered = System.currentTimeMillis();
    }

    public AdLog(String title, String logEntry, long timeEntered){
        this.title = title;
        this.logEntry = logEntry;
        this.timeEntered = timeEntered;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String getLogEntry() {
        return logEntry;
    }

    public void setLogEntry(String logEntry){
        this.logEntry = logEntry;
    }

    @Override
    public long getTimeEntered() {
        return 0;
    }

    public void setTimeEntered(long timeEntered){
        this.timeEntered = timeEntered;
    }
}
