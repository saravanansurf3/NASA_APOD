package com.sara.waie.apod.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sara.waie.apod.data.model.APOD

@Dao
interface ApodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(apod: APOD)

    @Update
    suspend fun update(apod: APOD)

    @Delete(entity = APOD::class)
    suspend fun delete(apod: APOD)


    @Query("DELETE FROM apod where date=:date")
    fun deleteByDate(date: String)

    @Query("select * from apod where date=:date")
    fun getApodDetail(date: String): LiveData<APOD>

    @Query("SELECT * from apod order by date desc limit 1")
    fun getLastKnown(): APOD
}