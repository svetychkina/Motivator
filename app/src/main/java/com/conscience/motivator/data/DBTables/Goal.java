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
    public String condition;
    public int userid;

    public Goal (String goalTitle, String description, String condition, int userid){
        this.goalTitle = goalTitle;
        this.description = description;
        this.condition = condition;
        this.userid = userid;
    }

}

