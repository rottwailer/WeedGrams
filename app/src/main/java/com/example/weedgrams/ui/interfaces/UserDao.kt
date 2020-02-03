package com.example.weedgrams.ui.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.weedgrams.ui.comon.Plantas
import com.google.firebase.firestore.auth.User

@Dao
    interface UserDao {
        @Query("SELECT * FROM plantas")
        fun getAll(): List<Plantas>

        @Query("SELECT * FROM plantas WHERE nombrePlanta IN (:userIds)")
        fun loadAllByIds(userIds: IntArray): List<User>

        @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
               "last_name LIKE :last LIMIT 1")
        fun findByName(first: String, last: String): User

        @Insert
        fun insertAll(vararg users: User)

        @Delete
        fun delete(user: User)
    }
