package com.conscience.motivator.data.DBTables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Goals",
        indices = {@Index(value = "goalid", unique = true)})
public class Goal{
    @PrimaryKey(autoGenerate = true)
    public int goalid;

    public String goalTitle;
    public String description;
    public String goalDate;
    public String goalTime;
    public int userid;

    public Goal (String goalTitle, String description, String goalDate, String goalTime, int userid){
        this.goalTitle = goalTitle;
        this.description = description;
        this.goalDate = goalDate;
        this.goalTime = goalTime;
        this.userid = userid;
    }

}

