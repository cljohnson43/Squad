package com.sports.nba.squad.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sports.nba.squad.data.Player
import com.sports.nba.squad.data.PlayersRepo

class PlayersViewModel(application: Application) : AndroidViewModel(application) {
    private val playersRepo: PlayersRepo by lazy { PlayersRepo(application.applicationContext)}

    fun getAllPlayers(): LiveData<List<Player>> = playersRepo.loadAllPlayers()
    fun insertPlayers(vararg players: Player): List<Long> = playersRepo.insertPlayers(*players)
    fun deletePlayers(vararg players: Player): Int = playersRepo.deletePlayers(*players)
}