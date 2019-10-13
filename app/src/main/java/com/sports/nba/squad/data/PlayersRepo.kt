package com.sports.nba.squad.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room

class PlayersRepo(context: Context) {
    private val db: SquadDB by lazy {
        Room.databaseBuilder(context, SquadDB::class.java, SquadDB.DB_NAME)
            .allowMainThreadQueries()
            .build()
    }

    fun loadAllPlayers(): LiveData<List<Player>> = db.getPlayersDAO().loadAllPlayers()

    fun insertPlayers(vararg players: Player): List<Long> =
        db.getPlayersDAO().insertPlayers(*players)

    suspend fun numberOfPlayers(): Int = db.getPlayersDAO().numberOfPlayers()

    fun deletePlayers(vararg players: Player): Int = db.getPlayersDAO().deletePlayers(*players)

    fun addPlayerToSquad(player: Player): Unit {
        player.id?.let {
            return db.getSquadDAO().insertToSquad(SquadSpot(it))
        }

        return
    }

    fun removePlayerFromSquad(player: Player): Int {
        player.id?.let {
            return db.getSquadDAO().deleteFromSquad(SquadSpot(it))
        }

        return 0
    }

    fun getSquad(): LiveData<List<SquadSpot>> = db.getSquadDAO().loadSquad()
}