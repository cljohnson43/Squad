package com.sports.nba.squad.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sports.nba.squad.data.Player
import com.sports.nba.squad.utils.Image

@BindingAdapter("backgroundColor")
fun backgroundColor(view: View, color: String) {
    view.setBackgroundColor(Color.parseColor(color))
}

@BindingAdapter("backgroundTint")
fun backgroundColor(view: FloatingActionButton, color: String) {
    view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color)))
}

@BindingAdapter("fromUrl")
fun fromUrl(imageView: ImageView, url: String) {
    Image.fromUrl(imageView, url)
}

@BindingAdapter("playerLabel")
fun playerLabel(textView: TextView, player: Player) {
    textView.text = "#${player.number} ${player.firstName.toUpperCase().trim()} ${player.lastName.toUpperCase().trim()}"
}