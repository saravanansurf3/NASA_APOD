package com.sara.waie.apod.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.sara.waie.apod.AppExecutors
import com.sara.waie.apod.data.dao.ApodDao
import com.sara.waie.apod.data.model.APOD
import com.sara.waie.apod.di.NetworkModule
import com.sara.waie.apod.network.BaseResponse
import com.sara.waie.apod.network.NetworkBoundResource
import com.sara.waie.apod.network.NetworkRequests
import com.sara.waie.apod.network.Resource
import com.sara.waie.apod.utils.DateUtils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepo @Inject constructor(
    private val appExecutors: AppExecutors,
    @NetworkModule.NASAApiWithLiveDataAdapter  private val networkRequests: NetworkRequests,
    private val db: AppDatabase,
    private val apodDao: ApodDao
) {
    private val TAG="AppRepo"


    fun getTodayContent(): LiveData<Resource<APOD>> {
        return object : NetworkBoundResource<APOD, APOD>(appExecutors) {
            override fun saveCallResult(item: APOD) {
                Log.i(TAG,"on Request saveCallResult :"+item)
                apodDao.insert(item)
            }

            override fun shouldFetch(data: APOD?): Boolean {
                Log.i(TAG,"on Request shouldFetch :"+data)
                return data==null
            }

            override fun loadFromDb(): LiveData<APOD> {
                Log.i(TAG,"on Request loadFromDb :")
                val dd= DateUtils.todayDate()
                Log.i(TAG,"on Request loadFromDb : datae :" +dd)
                return apodDao.getApodDetail(DateUtils.todayDate())
            }

            override fun createCall(): LiveData<BaseResponse<APOD>> {
                Log.i(TAG,"on Request createCall :")
                return networkRequests.getTodayContentLive(DateUtils.todayDate())
            }

        }.asLiveData()
    }

    fun getLastKnownApod():APOD{
        return apodDao.getLastKnown()
    }

}