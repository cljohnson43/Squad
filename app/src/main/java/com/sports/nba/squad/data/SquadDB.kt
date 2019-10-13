package com.sports.nba.squad.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Player::class, SquadSpot::class], version = 1)
abstract class SquadDB : RoomDatabase() {
    abstract fun getPlayersDAO(): PlayersDAO
    abstract fun getSquadDAO(): SquadDAO

    companion object {
        const val DB_NAME = "squad.db"
    }
}