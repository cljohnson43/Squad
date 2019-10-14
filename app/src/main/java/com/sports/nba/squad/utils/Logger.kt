package com.sports.nba.squad.utils

import android.util.Log

const val DEBUG_TAG = "debug_test"

object Logger {
    fun log(msg: String, tag: String = DEBUG_TAG){
        Log.d(tag, msg)
    }

}