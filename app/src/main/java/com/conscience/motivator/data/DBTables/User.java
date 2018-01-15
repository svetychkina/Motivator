package com.conscience.motivator.data.DBTables;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Users",
        indices = {@Index(value = "userid", unique = true)})
public class User {
    @PrimaryKey(autoGenerate = true)
    public int userid;

    public String username;
    public String phone;
    public String password;
    public String image;

    public User (String username, String phone, String password, String image) {
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.image = image;
    }
}

