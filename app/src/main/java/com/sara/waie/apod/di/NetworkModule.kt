package com.sara.waie.apod.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class NASAApiWithLiveDataAdapter


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class NASAApi
}