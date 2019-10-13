package com.sports.nba.squad.utils

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sports.nba.squad.data.Player
import java.io.InputStream

class PlayersJSONLoader(dataStream: InputStream) {

    lateinit var players: List<Player>

    init {
        val bufferedReader = dataStream.bufferedReader()
        var str: String
        str = bufferedReader.readText()

        players = Gson().fromJson(str, object : TypeToken<List<Player>>() {}.type)

        bufferedReader.close()
    }
}