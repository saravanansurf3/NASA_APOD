package com.sara.waie.apod.vm

import androidx.lifecycle.*
import com.sara.waie.apod.data.AppRepo
import com.sara.waie.apod.data.model.APOD
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApodDetailViewmodel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val appRepo: AppRepo
) : ViewModel() {
    val requestTodayContent = appRepo.getTodayContent()
    val lastKnown=MutableLiveData<APOD>()

    fun getLastKnownApod() {
        CoroutineScope(Dispatchers.IO).launch {
            lastKnown.postValue(appRepo.getLastKnownApod())
        }


    }

}