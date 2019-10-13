package com.sports.nba.squad.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Player::class], version = 1)
abstract class SquadDB : RoomDatabase() {
    abstract fun getPlayersDAO(): PlayersDAO

    companion object {
        const val DB_NAME = "squad.db"
    }
}