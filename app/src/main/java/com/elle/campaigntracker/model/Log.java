package com.elle.campaigntracker.model;

/**
 * Represents a log in a journal
 */

public interface Log {
    int getId();
    String getTitle();
    String getLogEntry();
    long getTimeEntered();
}
