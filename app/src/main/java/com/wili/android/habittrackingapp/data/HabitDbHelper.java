package com.wili.android.habittrackingapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.os.Build.VERSION_CODES.N;
import static com.wili.android.habittrackingapp.data.HabitContract.Habits.*;


/**
 * Created by Damian on 9/15/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Habits.db";
    public static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create a String with SQL statement
        String SQL_CREATE_HABITS = "CREATE TABLE " +
                TABLE_NAME +
                "(" + _ID + " INTEGER PRIMARY KEY, " +
                COLUMN_HABIT_NAME + " TEXT NOT NULL, " +
                COLUMN_HABIT_TIME + " INTEGER NOT NULL DEFAULT 0, " +
                COLUMN_HABIT_DAYS_DURATION + " INTEGER NOT NULL DEFAULT 0);";
        //Execute the SQL statement
        db.execSQL(SQL_CREATE_HABITS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Database doesn't change the version
    }
}
