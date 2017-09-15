package com.wili.android.habittrackingapp.data;

import android.provider.BaseColumns;

/**
 * Created by Damian on 9/15/2017.
 */

public final class HabitContract {
    private HabitContract(){}

    public static class Habits implements BaseColumns{
        public static final String TABLE_NAME = "habits";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_DAYS_DURATION ="days";
        public static final String COLUMN_HABIT_TIME = "duration";
    }
}
