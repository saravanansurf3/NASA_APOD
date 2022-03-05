package com.sara.waie.apod.ui.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sara.waie.apod.R
import com.squareup.picasso.Picasso

object BindingAdapters {
    @BindingAdapter(value = ["imageUrl"], requireAll = true)
    @JvmStatic
    fun bindImageFromUrl(imageView: ImageView, imageUrl: String?) {
        if (!imageUrl.isNullOrEmpty()) {
            Picasso.get().load(imageUrl).fit().placeholder(R.drawable.dummy_bg)
                .error(R.drawable.dummy_bg).fit().into(imageView)
        }
    }
}