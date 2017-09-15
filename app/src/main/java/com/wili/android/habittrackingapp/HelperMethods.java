package com.wili.android.habittrackingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.wili.android.habittrackingapp.data.HabitDbHelper;

import static com.wili.android.habittrackingapp.data.HabitContract.Habits.COLUMN_HABIT_DAYS_DURATION;
import static com.wili.android.habittrackingapp.data.HabitContract.Habits.COLUMN_HABIT_NAME;
import static com.wili.android.habittrackingapp.data.HabitContract.Habits.COLUMN_HABIT_TIME;
import static com.wili.android.habittrackingapp.data.HabitContract.Habits.TABLE_NAME;
import static com.wili.android.habittrackingapp.data.HabitContract.Habits._ID;


/**
 * Created by Damian on 9/15/2017.
 */

public class HelperMethods {
    private HabitDbHelper mHabitDbHelper;
    private Context context;

    public HelperMethods(Context context) {
        this.context = context;
        mHabitDbHelper = new HabitDbHelper(context);
    }

    public void insertToDb(String habitName, int habitDuration) {
        SQLiteDatabase writableDatabase = mHabitDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_HABIT_NAME, habitName);
        values.put(COLUMN_HABIT_TIME, habitDuration);
        values.put(COLUMN_HABIT_DAYS_DURATION, +1);
        long newRowNumber = writableDatabase.insert(TABLE_NAME, null, values);
        String toastText;
        if (newRowNumber > 0)
            toastText = "Habit saved with id: " + newRowNumber;
        else
            toastText = "Error";
        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();

    }

    public Cursor readDb() {
        SQLiteDatabase readableDatabase = mHabitDbHelper.getReadableDatabase();
        String [] projection = {
                _ID,
                COLUMN_HABIT_NAME,
                COLUMN_HABIT_TIME
        };
        Cursor cursor = readableDatabase.query(
                TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
}
