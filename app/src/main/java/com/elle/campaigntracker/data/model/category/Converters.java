package com.elle.campaigntracker.data.model.category;

import android.arch.persistence.room.TypeConverter;
import android.util.Log;

import com.elle.campaigntracker.data.model.Item;

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
    public static Item.ItemCategory fromItemString(String category){
        Item.ItemCategory itemCategory;
        try {
            itemCategory = Item.ItemCategory.valueOf(category);
        }catch (IllegalArgumentException e){
            Log.e(TAG, e.toString());
            itemCategory = Item.ItemCategory.OTHER;
        }
        return itemCategory;
    }

    @TypeConverter
    public static String fromItemCategory(Item.ItemCategory itemCategory){
        return itemCategory.toString();
    }

    @TypeConverter
    public static String fromDieEnum(Dice dice){
        return dice.toString();
    }

    @TypeConverter
    public static Dice fromDieString(String die){
        Dice dice;
        try {
            dice = Dice.valueOf(die);
        }catch (IllegalArgumentException e) {
            Log.e(TAG, e.toString());
            dice = Dice.D20;
        }
        return dice;
    }

    @TypeConverter
    public static String fromClass(RoleClass.Role pcClass){
        return pcClass.toString();
    }

    @TypeConverter
    public RoleClass.Role fromClassString(String pcClass){
        RoleClass.Role roleClass;
        try {
            roleClass = RoleClass.Role.valueOf(pcClass);
        }catch (IllegalArgumentException e) {
            Log.e(TAG, e.toString());
            roleClass = RoleClass.Role.OTHER;
        }
        return roleClass;
    }
}
