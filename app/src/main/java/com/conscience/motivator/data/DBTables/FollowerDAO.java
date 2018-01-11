package com.conscience.motivator.data.DBTables;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FollowerDAO {
    @Query("SELECT * from Followers")
    List<Follower> getAll();

    @Query("SELECT goalid FROM followers WHERE userid IN (:userIds)")
    List<Follower> loadAllByIds(int[] userIds);

}
