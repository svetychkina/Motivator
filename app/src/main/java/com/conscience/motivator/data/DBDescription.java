package com.conscience.motivator.data;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;


/**
 * Created by sairi on 03.12.2017.
 DatabaseDescription.java
 Класс описывает имя таблицы и имена столбцов базы данных, а также
 содержит другую информацию, необходимую для ContentProvider
 */

public class DBDescription {
    public  static  final String AUTHORITY = "com.conscience.motivator.data";

    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    /*public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "motivatorDB";
    public static final String KEY_ID = "id";*/

    public static final class database implements BaseColumns {

        //table users
        public static final String TABLE_USERS = "Users";
        public static final Uri USERS_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_USERS).build();
        public static final String KEY_USERNAME = "username";
        public static final String KEY_PHONE = "phone";
        public static final String KEY_PASS = "password";
        //public static final String KEY_USER_ID_CARD = "idCard";
        public static final String KEY_IMAGE = "image";

        public static Uri buildUserUri(long id) {
            return ContentUris.withAppendedId(USERS_URI, id);
        }

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
    }
}
