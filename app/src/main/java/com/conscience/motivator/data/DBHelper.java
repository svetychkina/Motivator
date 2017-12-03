package com.conscience.motivator.data;

import android.content.ContentValues;
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

    public DBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //public static final String KEY_ID = "id";
    /*
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
    public static final String KEY_GOAL_CONDITION = "goalCondition";*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Table user
        db.execSQL("CREATE TABLE IF NOT EXISTS " + DBDescription.database.TABLE_USERS + "(" +
                DBDescription.database._ID + "integer primary key autoincrement, " +
                DBDescription.database.KEY_USERNAME + "text," +
                DBDescription.database.KEY_PHONE + "integer," +
                DBDescription.database.KEY_PASS + "text," +
                DBDescription.database.KEY_IMAGE + "longblob" +
                ");"
        );

        //table goals
        db.execSQL("CREATE TABLE IF NOT EXISTS " + DBDescription.database.TABLE_GOALS + "(" +
                DBDescription.database._ID + "integer primary key autoincrement, " +
                DBDescription.database.KEY_TITLE + "text," +
                DBDescription.database.KEY_DESCRIPTION + "text," +
                DBDescription.database.KEY_CONDITION + "text," +
                DBDescription.database.KEY_GOAL_ID_USER + "integer" +
                ");"
        );

        //table followers
        db.execSQL("CREATE TABLE IF NOT EXISTS " + DBDescription.database.TABLE_FOLLOWERS + "(" +
                DBDescription.database._ID + "integer primary key autoincrement," +
                DBDescription.database.KEY_FOLLOWERS_ID_USERS + "integer," +
                DBDescription.database.KEY_FOLLOWERS_ID_GOALS + "integer" +
                ");"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS " + DBDescription.database.TABLE_LOG_ENTRY + "(" +
                DBDescription.database._ID + "integer primary key autoincrement," +
                DBDescription.database.KEY_LOG_ID_GOALS + "integer," +
                DBDescription.database.KEY_GOAL_TITLE + "text," +
                DBDescription.database.KEY_GOAL_DESCRIPTION + "text," +
                DBDescription.database.KEY_GOAL_CONDITION + "text" +
                ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + DBDescription.database.TABLE_USERS);
        db.execSQL("drop table if exists " + DBDescription.database.TABLE_GOALS);
        db.execSQL("drop table if exists " + DBDescription.database.TABLE_FOLLOWERS);
        db.execSQL("drop table if exists " + DBDescription.database.TABLE_LOG_ENTRY);

        onCreate(db);
        db.close();
    }

    /*public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }*/



}
