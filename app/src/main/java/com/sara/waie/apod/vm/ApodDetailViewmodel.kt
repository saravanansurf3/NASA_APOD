package com.sara.waie.apod.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ApodDetailViewmodel @Inject constructor(private val savedStateHandle: SavedStateHandle) : ViewModel() {
}