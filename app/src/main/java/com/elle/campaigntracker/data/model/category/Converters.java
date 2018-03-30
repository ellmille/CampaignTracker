package com.elle.campaigntracker.data.model.category;

import android.arch.persistence.room.TypeConverter;
import android.util.Log;

/**
 * Converts Alignment to a String and back to enum
 */

public class Converters {
    private static final String TAG = "CONVERTERS";

    @TypeConverter
    public static Alignment fromString(String alignment){
        Alignment returnAlignment;
        try {
            returnAlignment = Alignment.valueOf(alignment);
        }catch (IllegalArgumentException e){
            Log.e(TAG, e.toString());
            returnAlignment = Alignment.TRUE_NEUTRAL;
        }
        return returnAlignment;
    }

    @TypeConverter
    public static String fromAlignment(Alignment alignment){
        return alignment.toString();
    }

    @TypeConverter
    public static ItemCategory fromItemString(String category){
        ItemCategory itemCategory;
        try {
            itemCategory = ItemCategory.valueOf(category);
        }catch (IllegalArgumentException e){
            Log.e(TAG, e.toString());
            itemCategory = ItemCategory.OTHER;
        }
        return itemCategory;
    }

    @TypeConverter
    public static String fromItemCategory(ItemCategory itemCategory){
        return itemCategory.toString();
    }
}
