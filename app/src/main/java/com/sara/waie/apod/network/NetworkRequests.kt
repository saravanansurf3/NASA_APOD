package com.sara.waie.apod.network

import androidx.lifecycle.LiveData
import com.sara.waie.apod.BuildConfig
import com.sara.waie.apod.data.model.APOD
import com.sara.waie.apod.network.adapter.LiveDataCallAdapterFactory
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface NetworkRequests {
    @GET("apod")
    fun getTodayContentLive(@Query("date") date: String,@Query("api_key") apiKey: String = BuildConfig.NASA_API_KEY): LiveData<BaseResponse<APOD>>


    companion object {
        private const val BASE_URL = "https://api.nasa.gov/planetary/"

        fun create(): NetworkRequests {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL.toHttpUrlOrNull()!!)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkRequests::class.java)
        }

        fun createWithLiveDataAdapter(): NetworkRequests {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder().addInterceptor(logger).build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkRequests::class.java)
        }


    }
}