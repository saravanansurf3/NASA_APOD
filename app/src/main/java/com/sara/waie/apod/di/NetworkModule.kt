package com.sara.waie.apod.di

import com.sara.waie.apod.network.NetworkRequests
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @NASAApi
    @Provides
    @Singleton
    fun provideNetworkRequests(): NetworkRequests {
        return NetworkRequests.create()
    }


    @NASAApiWithLiveDataAdapter
    @Provides
    @Singleton
    fun provideNetworkRequestsWithLiveDataAdapter(): NetworkRequests {
        return NetworkRequests.createWithLiveDataAdapter()
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class NASAApiWithLiveDataAdapter


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class NASAApi
}