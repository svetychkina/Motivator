package com.conscience.motivator.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.conscience.motivator.R;

/**
 * Created by sairi on 03.12.2017.
 */

public class MotivatorContentProvider extends ContentProvider {
    private DBHelper dbHelper;
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int ONE_USER = 1; //one user
    private static final int USERS = 2; //table of users

    static {
        uriMatcher.addURI(DBDescription.AUTHORITY, DBDescription.database.TABLE_USERS + "/#", ONE_USER); //uri for user
        uriMatcher.addURI(DBDescription.AUTHORITY, DBDescription.database.TABLE_USERS, USERS); //uri for table
    }

    @Override
    public boolean onCreate() {
        //creating object dbhelper
        dbHelper = new DBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(DBDescription.database.TABLE_USERS);

        switch (uriMatcher.match(uri)){
            case ONE_USER: //choose user with id
                queryBuilder.appendWhere(DBDescription.database._ID + "=" + uri.getLastPathSegment());
            break;

            case USERS:
                break;
            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.invalid_query_uri) + uri);
        }
        //get one or all contacts
        Cursor cursor = queryBuilder.query(dbHelper.getReadableDatabase(), projection, selection, selectionArgs, null, null, sortOrder);
        //listener changes in context settings
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Uri newUserUri = null;
        switch (uriMatcher.match(uri)){
            case USERS:
                long rowId = dbHelper.getWritableDatabase().insert(DBDescription.database.TABLE_USERS, null, values);
                if (rowId > 0) {
                    newUserUri = DBDescription.database.buildUserUri(rowId);

                    getContext().getContentResolver().notifyChange(uri, null);
                } else throw new SQLException(getContext().getString(R.string.incert_failed) + uri);
                  break;

                default:
                    throw new UnsupportedOperationException(getContext().getString(R.string.invalid_query_uri) + uri);
        }
        return newUserUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int numOfRowsDLTD;

        switch (uriMatcher.match(uri)){
            case ONE_USER:
                String id = uri.getLastPathSegment();

                numOfRowsDLTD = dbHelper.getWritableDatabase().delete(DBDescription.database.TABLE_USERS, DBDescription.database._ID + "=" + id, selectionArgs);
                break;

            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.invalid_delete_uri) + uri);
        }
        if (numOfRowsDLTD !=0){
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return numOfRowsDLTD;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int numOfRowsUPD; //1 - profit, 0 - fail
        switch(uriMatcher.match(uri)){
            case ONE_USER:
                String id = uri.getLastPathSegment();

                numOfRowsUPD = dbHelper.getWritableDatabase().update(DBDescription.database.TABLE_USERS, values, DBDescription.database._ID + "=" + id, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.invalid_update_uri) + uri);
        }
        if (numOfRowsUPD !=0){
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return numOfRowsUPD;
    }
}
