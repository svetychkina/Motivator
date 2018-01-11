package com.conscience.motivator.data.DBTables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Followers")
public class Follower{
    @PrimaryKey
    public int follid;

    public int userid;
    public int goalid;
}

