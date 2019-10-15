package com.sports.nba.squad.adapters

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sports.nba.squad.utils.Image

@BindingAdapter("backgroundColor")
fun backgroundColor(view: View, color: String) {
    view.setBackgroundColor(Color.parseColor(color))
}

@BindingAdapter("fromUrl")
fun fromUrl(imageView: ImageView, url: String) {
    Image.fromUrl(imageView, url)
}