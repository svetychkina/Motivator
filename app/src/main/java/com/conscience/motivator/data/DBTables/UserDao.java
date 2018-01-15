package com.conscience.motivator.data.DBTables;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    //TODO make right request
//    @Query("SELECT phone, password from Users WHERE username LIKE :name AND password LIKE :pass")
    @Query("SELECT * from Users")
    List<User> getAll();

    @Query("SELECT * FROM Users WHERE username LIKE :first AND "
            + "password LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}

