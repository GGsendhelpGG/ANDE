package com.example.freelancerhomescreen;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowData extends SQLiteOpenHelper {
    private static final String TABLE_PROJECTS = "Projects";
    private static final String TABLE_SKILLS = "Skills";
    private static final String TABLE_YOURSKILLS = "YourSkills";
    private static final String TABLE_EXPERIENCE = "Experience";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "FirehireDB";

    public ShowData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        SQLiteDatabase db = this.getReadableDatabase();

        db.execSQL("SELECT * FROM Certifications");
        db.execSQL("SELECT * FROM Freelancers");
        db.execSQL("SELECT * FROM Employers");
        db.execSQL("SELECT * FROM " + TABLE_PROJECTS);
        db.execSQL("SELECT * FROM " + TABLE_SKILLS);
        db.execSQL("SELECT * FROM " + TABLE_YOURSKILLS);
        db.execSQL("SELECT * FROM " + TABLE_EXPERIENCE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
