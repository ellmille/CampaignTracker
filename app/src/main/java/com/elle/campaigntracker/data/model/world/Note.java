package com.elle.campaigntracker.data.model.world;

/**
 * Interface for notes
 */

public interface Note {
    int getId();

    void setId(int id);

    int getForeignId();

    void setForeignId(int fId);

    String getMessage();

    void setMessage(String message);

    long getTimeCreated();

    void setTimeCreated(long timeCreated);
}
