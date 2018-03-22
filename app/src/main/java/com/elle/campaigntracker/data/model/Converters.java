package com.elle.campaigntracker.data.model;

import android.arch.persistence.room.TypeConverter;

/**
 * Converts Alignment to a String and back to enum
 */

public class Converters {
    @TypeConverter
    public static Alignment fromString(String alignment){
        Alignment returnAlignment;
        try {
            returnAlignment = Alignment.valueOf(alignment);
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
            returnAlignment = Alignment.TRUE_NEUTRAL;
        }
        return returnAlignment;
    }

    @TypeConverter
    public static String fromAlignment(Alignment alignment){
        return alignment.toString();
    }
}
