package com.elle.campaigntracker.data.model;

import android.arch.persistence.room.Ignore;

/**
 * POJO for notes on NPCs
 */

public class Note {
    private int id;
    private int npcId;
    private String message;

    @Ignore
    public Note(String message){
        this.message = message;
    }

    public Note(int id, int npcId, String message){
        this.id = id;
        this.npcId = npcId;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNpcId() {
        return npcId;
    }

    public void setNpcId(int npcId) {
        this.npcId = npcId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
