package com.sports.nba.squad.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sports.nba.squad.data.Player
import com.sports.nba.squad.data.PlayersRepo

class PlayerDetailViewModel(application: Application) :
    AndroidViewModel(application) {
    private val playersRepo: PlayersRepo by lazy { PlayersRepo.getInsance(application.applicationContext) }

    var player: Player? = null

    fun setPlayer(playerId: Long) {
        player = playersRepo.getPlayer(playerId!!)
    }

    fun addPlayerToSquad() {
        playersRepo.addPlayerToSquad(player!!)
    }
}
