package com.sara.waie.apod.di

import android.content.Context
import androidx.room.Room
import com.sara.waie.apod.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context): AppDatabase {
        val name = "myAPOD.db"
        return Room.databaseBuilder(context, AppDatabase::class.java, name).build()
    }

    @Provides
    @Singleton
    fun getApodDao(db: AppDatabase) = db.apodDao()
}