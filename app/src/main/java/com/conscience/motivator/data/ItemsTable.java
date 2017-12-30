package com.conscience.motivator.data;

import android.provider.BaseColumns;

public class ItemsTable implements BaseColumns{

    //Table user
    public static final String TABLE_USERS = "Users";
    //public static final String USER_ID = "userId";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_PASS = "password";
    //public static final String KEY_USER_ID_CARD = "idCard";
    public static final String KEY_IMAGE = "image";

    public static final String SQL_CREATE_USERS = "CREATE TABLE IF NOT EXISTS " + TABLE_USERS + "(" +
            _ID + "integer primary key autoincrement, " +
            KEY_USERNAME + "text," +
            KEY_PHONE + "integer," +
            KEY_PASS + "text," +
            KEY_IMAGE + "text" + ");";

    //table goals
    public static final String TABLE_GOALS = "Goals";
    //public static final String GOAL_ID = "goalId";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_CONDITION = "condition";
    public static final String KEY_GOAL_ID_USER = "idUser";

    public static final String SQL_CREATE_GOALS = "CREATE TABLE IF NOT EXISTS " + TABLE_GOALS + "(" +
            _ID + "integer primary key autoincrement, " +
            KEY_TITLE + "text," +
            KEY_DESCRIPTION + "text," +
            KEY_CONDITION + "text," +
            KEY_GOAL_ID_USER + "integer" + ");";


    //table followers
    public static final String TABLE_FOLLOWERS = "Followers";
    //public static final String FOLLOWER_ID = "followerId";
    public static final String KEY_FOLLOWERS_ID_USERS = "idUsers";
    public static final String KEY_FOLLOWERS_ID_GOALS = "idGoals";

    public static final String SQL_CREATE_FOLLOWERS = "CREATE TABLE IF NOT EXISTS " + TABLE_FOLLOWERS + "(" +
            _ID + "integer primary key autoincrement," +
            KEY_FOLLOWERS_ID_USERS + "integer," +
            KEY_FOLLOWERS_ID_GOALS + "integer" + ");";

    //table log
    public static final String TABLE_LOG_ENTRY = "logEntry";
    //public static final String LOG_ID = "logId";
    public static final String KEY_LOG_ID_GOALS = "idGoals";
    public static final String KEY_GOAL_TITLE = "goalTitle";
    public static final String KEY_GOAL_DESCRIPTION = "goalDescription";
    public static final String KEY_GOAL_CONDITION = "goalCondition";

    public static final String SQL_CREATE_LOG = "CREATE TABLE IF NOT EXISTS " + TABLE_LOG_ENTRY + "(" +
            _ID + "integer primary key autoincrement," +
            KEY_LOG_ID_GOALS + "integer," +
            KEY_GOAL_TITLE + "text," +
            KEY_GOAL_DESCRIPTION + "text," +
            KEY_GOAL_CONDITION + "text" + ");";


    public static final String SQL_DELETE_USERS = "DROP_TABLE " + TABLE_USERS;
    public static final String SQL_DELETE_GOALS = "DROP_TABLE " + TABLE_GOALS;
    public static final String SQL_DELETE_FOLLOWERS = "DROP_TABLE " + TABLE_FOLLOWERS;
    public static final String SQL_DELETE_LOG = "DROP_TABLE " + TABLE_LOG_ENTRY;

}
