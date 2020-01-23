package com.adaoud.leboncoin.utils

import android.widget.ImageView
import com.adaoud.leboncoin.R
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import androidx.databinding.BindingAdapter


@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(strTeamBadge: String?) {
    val options = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.placeholder_album_thumbnail)
            .error(R.drawable.error_image)
            .priority(Priority.HIGH)

    Glide.with(context)
            .load(strTeamBadge)
            .apply(options)
            .into(this)
}