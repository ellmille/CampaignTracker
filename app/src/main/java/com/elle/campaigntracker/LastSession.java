package com.elle.campaigntracker;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Quick class to grab the last used char
 */

//todo: this should just save the ID of the last used character
public class LastSession {
    private static int charId;

    private static final String SESSION_KEY = "LAST_SESSION";
    private static final String CHAR_ID = "LAST_CHAR";

    public LastSession(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SESSION_KEY, Context.MODE_PRIVATE);
        charId = sharedPreferences.getInt(CHAR_ID, 1);
    }

    public int getCharId(){
        return charId;
    }

    public static void setCharId(int charId, Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SESSION_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(CHAR_ID, charId);
        editor.apply();
    }
}
