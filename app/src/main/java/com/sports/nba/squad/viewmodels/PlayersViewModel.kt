package com.sports.nba.squad.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sports.nba.squad.R
import com.sports.nba.squad.data.Player
import com.sports.nba.squad.data.PlayersRepo
import com.sports.nba.squad.utils.PlayersJSONLoader
import java.io.InputStream

class PlayersViewModel(application: Application) : AndroidViewModel(application) {
    private val playersRepo: PlayersRepo by lazy { PlayersRepo(application.applicationContext)}

    init {
        val dataStream: InputStream = application.resources.openRawResource(R.raw.nba_bios)
        val playersJSONLoader = PlayersJSONLoader(dataStream)
        dataStream.close()

        playersJSONLoader.players.forEach{
            playersRepo.insertPlayers(it)
        }

    }

    fun getAllPlayers(): LiveData<List<Player>> = playersRepo.loadAllPlayers()
    fun insertPlayers(vararg players: Player): List<Long> = playersRepo.insertPlayers(*players)
    fun deletePlayers(vararg players: Player): Int = playersRepo.deletePlayers(*players)
}