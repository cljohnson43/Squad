package com.sports.nba.squad.adapters

import android.graphics.Color
import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("backgroundColor")
fun backgroundColor(view: View, color: String) {
    view.setBackgroundColor(Color.parseColor(color))
}