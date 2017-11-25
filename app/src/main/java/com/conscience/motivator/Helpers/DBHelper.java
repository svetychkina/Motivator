package com.conscience.motivator.Helpers;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sairi on 25.11.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "motivatorDB";
    public static final String KEY_ID = "id";

    //table users
    public static final String TABLE_USERS = "Users";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_PASS = "password";
    //public static final String KEY_USER_ID_CARD = "idCard";
    public static final String KEY_IMAGE = "image";

    //table goals
    public static final String TABLE_GOALS = "Goals";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_CONDITION = "condition";
    public static final String KEY_GOAL_ID_USER = "idUser";

    //table followers
    public static final String TABLE_FOLLOWERS = "Followers";
    public static final String KEY_FOLLOWERS_ID_USERS = "idUsers";
    public static final String KEY_FOLLOWERS_ID_GOALS = "idGoals";

    //table log
    public static final String TABLE_LOG_ENTRY = "logEntry";
    public static final String KEY_LOG_ID_GOALS = "idGoals";
    public static final String KEY_GOAL_TITLE = "goalTitle";
    public static final String KEY_GOAL_DESCRIPTION = "goalDescription";
    public static final String KEY_GOAL_CONDITION = "goalCondition";

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Table users
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_USERS + "(" +
                KEY_ID + "integer primary key, " +
                KEY_USERNAME + "text," +
                KEY_PHONE + "integer," +
                KEY_PASS + "text," +
                KEY_IMAGE + "longblob" +
                ");"
        );

        //table goals
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_GOALS + "(" +
                KEY_ID + "integer primary key, " +
                KEY_TITLE + "text," +
                KEY_DESCRIPTION + "text," +
                KEY_CONDITION + "text," +
                KEY_GOAL_ID_USER + "integer" +
                ");"
        );

        //table followers
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_FOLLOWERS + "(" +
                KEY_ID + "integer primary key," +
                KEY_FOLLOWERS_ID_USERS + "integer," +
                KEY_FOLLOWERS_ID_GOALS + "integer" +
                ");"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_LOG_ENTRY + "(" +
                KEY_ID + "integer primary key," +
                KEY_LOG_ID_GOALS + "integer," +
                KEY_GOAL_TITLE + "text," +
                KEY_GOAL_DESCRIPTION + "text," +
                KEY_GOAL_CONDITION + "text" +
                ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_USERS);
        db.execSQL("drop table if exists " + TABLE_GOALS);
        db.execSQL("drop table if exists " + TABLE_FOLLOWERS);
        db.execSQL("drop table if exists " + TABLE_LOG_ENTRY);

        onCreate(db);
        db.close();
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

}
