package com.sara.waie.apod

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepo @Inject constructor(
    private val appExecutors: AppExecutors,
) {
}