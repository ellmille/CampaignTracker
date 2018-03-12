package com.elle.campaigntracker.data.repo.db;

import android.provider.BaseColumns;

/**
 * SQLite contact that defines table names and column names for a single table
 */

public final class ReaderContract {
    private ReaderContract(){}

    public static class Entry implements BaseColumns {
        public static final String TABLE_NAME = "character";

    }
}
