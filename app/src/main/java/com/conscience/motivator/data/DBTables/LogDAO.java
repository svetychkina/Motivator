package com.conscience.motivator.data.DBTables;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface LogDAO {
    @Query("SELECT * from LOG")
    List<Log> getAll();

    @Query("SELECT goalid from LOG WHERE userid = 0")
    List<Log> get();
}
