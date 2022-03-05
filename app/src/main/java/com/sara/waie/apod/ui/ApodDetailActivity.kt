package com.sara.waie.apod.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.sara.waie.apod.R
import com.sara.waie.apod.databinding.ActivityApodDetailBinding
import com.sara.waie.apod.network.Status
import com.sara.waie.apod.vm.ApodDetailViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ApodDetailActivity : AppCompatActivity() {
    private val viewmodel: ApodDetailViewmodel by viewModels()
    private lateinit var binding: ActivityApodDetailBinding
    private val TAG = "ApodDetailActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_apod_detail)

        viewmodel.requestTodayContent.observe(this, Observer {
            binding.status = it.status
            when (it.status) {
                Status.SUCCESS -> {
                    Log.i(TAG, "on Request Successs :" + it.data)
                    binding.apod = it.data
                }
                Status.ERROR -> {
                    Log.i(TAG, "on Request ERROR :")
                    viewmodel.getLastKnownApod()

                }
                Status.SERVER_NOT_REACHABLE -> {
                    Log.i(TAG, "on Request ERROR :")
                    viewmodel.getLastKnownApod()
                }

                Status.LOADING -> {
                    Log.i(TAG, "on Request LOADING... :")
                }
            }
        })
        viewmodel.lastKnown.observe(this, Observer {
            it?.let { binding.apod = it }
        })

    }

}