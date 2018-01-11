package com.conscience.motivator.data.DBTables;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Goals")
public class Goal{
    @PrimaryKey
    public int goalid;

    public String goalTitle;
    public String description;
    public String condition;
    public int userid;

}

