package com.sports.nba.squad.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

object Image {
    fun fromUrl(imageView: ImageView, passedUrl: String?) {
        var url = passedUrl

        if (passedUrl.isNullOrEmpty() || passedUrl == "#") {
            url = "https://b.fssta.com/uploads/application/bigboard/shared/default-headshot.png"
        }

        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }
}