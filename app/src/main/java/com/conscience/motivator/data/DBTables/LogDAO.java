package com.conscience.motivator.data.DBTables;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface LogDAO {
    @Query("SELECT * from LogEntry")
    List<LogEntry> getAll();

    @Query("SELECT goalid from LogEntry WHERE userid = 0")
    List<LogEntry> get();
}
