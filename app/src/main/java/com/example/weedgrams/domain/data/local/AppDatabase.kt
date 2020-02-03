package com.example.weedgrams.domain.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weedgrams.ui.comon.Plantas
import com.example.weedgrams.ui.interfaces.UserDao

@Database(entities = arrayOf(Plantas::class), version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun userDao(): UserDao
    }
