package com.sara.waie.apod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.sara.waie.apod.databinding.ActivityApodDetailBinding
import com.sara.waie.apod.vm.ApodDetailViewmodel

class ApodDetailActivity : AppCompatActivity() {
    private val viewmodel: ApodDetailViewmodel by viewModels()
    private lateinit var binding: ActivityApodDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_apod_detail)
    }
}