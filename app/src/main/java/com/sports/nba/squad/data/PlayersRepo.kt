package com.sports.nba.squad.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room

class PlayersRepo(context: Context) {
    private val db: SquadDB by lazy {
        Room.databaseBuilder(context, SquadDB::class.java, SquadDB.DB_NAME).build()
    }

    fun loadAllPlayers(): LiveData<List<Player>> = db.getPlayersDAO().loadAllPlayers()
    fun insertPlayers(vararg players: Player): List<Long> = db.getPlayersDAO().insertPlayers(*players)
    fun deletePlayers(vararg players: Player): Int = db.getPlayersDAO().deletePlayers(*players)
}