package com.sports.nba.squad.data

import android.content.Context
import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.Room

class PlayersRepo private constructor(context: Context) {
    private val db: SquadDB by lazy {
        Room.databaseBuilder(context, SquadDB::class.java, SquadDB.DB_NAME)
            .allowMainThreadQueries()
            .build()
    }

    fun loadAllPlayers(): LiveData<List<Player>> = db.getPlayersDAO().loadAllPlayers()

    fun getPlayer(id: Long): Player = db.getPlayersDAO().loadPlayer(id)

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

    fun getSquad(): LiveData<List<SquadSpot>> = db.getSquadDAO().getSquad()

    fun loadSquad(): Cursor = db.getPlayersDAO().loadSquad()

    fun removeFromSquad(id: Long): Int = db.getSquadDAO().deleteFromSquad(SquadSpot(id))

    companion object {
        private var instance: PlayersRepo? = null

        @Synchronized
        fun getInsance(context: Context): PlayersRepo {
            if (instance == null) {
                instance = PlayersRepo(context)
                return instance!!
            }

            return instance!!
        }
    }
}