package com.conscience.motivator.data.DBTables;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface GoalDAO {
    @Query("SELECT * from Goals")
    List<Goal> getAll();

    @Query("SELECT * FROM goals WHERE userid LIKE :userID")
    Goal findByUser(String userID);

    @Insert
    void insertGoal(Goal goal1, Goal goal2);

    @Delete
    void delete(Goal goal);
}
