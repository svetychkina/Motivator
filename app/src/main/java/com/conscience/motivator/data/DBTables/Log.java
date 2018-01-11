package com.conscience.motivator.data.DBTables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "LOG")
public class Log{
    @PrimaryKey
    public int logid;

    public int goalid;
    public int userid;
    public String goalTitle;
    public String goalDescription;
    public String goalCondition;
}
