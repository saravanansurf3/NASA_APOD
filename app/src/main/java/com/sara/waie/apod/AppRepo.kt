package com.sara.waie.apod

import com.sara.waie.apod.data.AppDatabase
import com.sara.waie.apod.data.dao.ApodDao
import com.sara.waie.apod.di.NetworkModule
import com.sara.waie.apod.network.NetworkRequests
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepo @Inject constructor(
    private val appExecutors: AppExecutors,
    @NetworkModule.NASAApiWithLiveDataAdapter  private val networkRequests: NetworkRequests,
    private val db: AppDatabase,
    private val apodDao: ApodDao
) {
}