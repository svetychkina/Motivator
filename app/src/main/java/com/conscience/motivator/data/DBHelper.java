package com.conscience.motivator.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.LoginFilter;

import java.util.ArrayList;

import static com.conscience.motivator.data.ItemsTable.KEY_USERNAME;


public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "motivator.db";

    public DBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(ItemsTable.SQL_CREATE_USERS);
       db.execSQL(ItemsTable.SQL_CREATE_GOALS);
       db.execSQL(ItemsTable.SQL_CREATE_FOLLOWERS);
       db.execSQL(ItemsTable.SQL_CREATE_LOG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ItemsTable.SQL_DELETE_USERS);
        db.execSQL(ItemsTable.SQL_DELETE_GOALS);
        db.execSQL(ItemsTable.SQL_DELETE_FOLLOWERS);
        db.execSQL(ItemsTable.SQL_DELETE_LOG);

        onCreate(db);
        db.close();
    }

    public void addNewUser(ContentValues newUser){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ItemsTable.TABLE_USERS,null, newUser);
        db.close();
    }

    public void addNewGoal(ContentValues newGoal){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ItemsTable.TABLE_GOALS, null, newGoal);
        db.close();
    }


}
