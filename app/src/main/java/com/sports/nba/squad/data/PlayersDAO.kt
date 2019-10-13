package com.sports.nba.squad.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlayersDAO {
    @Query("SELECT * FROM ${Player.TABLE_NAME}")
    fun loadAllPlayers(): LiveData<List<Player>>

    @Insert
    fun insertPlayers(vararg players: Player): List<Long>

    @Delete
    fun deletePlayers(vararg players: Player): Int
}