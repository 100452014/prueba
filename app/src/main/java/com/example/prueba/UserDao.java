package com.example.prueba;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User WHERE email LIKE :email LIMIT 1")
    User selectByEmail(String email);

    @Insert()
    long insert(User user);
}