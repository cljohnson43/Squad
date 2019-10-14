package com.sports.nba.squad.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sports.nba.squad.data.Player
import com.sports.nba.squad.data.PlayersRepo

class PlayerDetailViewModel(application: Application, private val playerId: Int?) :
    AndroidViewModel(application) {
    private val playersRepo: PlayersRepo by lazy { PlayersRepo.getInsance(application.applicationContext) }

    val player: Player by lazy { playersRepo.getPlayer(playerId!!)}

    fun addPlayerToSquad() {
        playersRepo.addPlayerToSquad(player)
    }
}
