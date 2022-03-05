package com.sara.waie.apod.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sara.waie.apod.data.dao.ApodDao
import com.sara.waie.apod.data.model.APOD

@Database(
    entities = [APOD::class],
    exportSchema = false,
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun apodDao(): ApodDao
}