package com.sports.nba.squad.data

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlayersDAO {
    @Query(
        """
        SELECT * 
        FROM ${Player.TABLE_NAME} 
        ORDER BY ${Player.COLUMN_LAST_NAME} ASC, ${Player.COLUMN_FIRST_NAME} ASC"""
    )
    fun loadAllPlayers(): LiveData<List<Player>>

    @Query("SELECT * FROM ${Player.TABLE_NAME} WHERE id = :id")
    fun loadPlayer(id: Long): Player

    @Query("SELECT COUNT(*) FROM ${Player.TABLE_NAME}")
    suspend fun numberOfPlayers(): Int

    @Insert
    fun insertPlayers(vararg players: Player): List<Long>

    @Delete
    fun deletePlayers(vararg players: Player): Int

    @Query(
        """
        SELECT * FROM ${Player.TABLE_NAME} as player
        INNER JOIN ${SquadSpot.TABLE_NAME} AS squad
        ON player.${Player.COLUMN_ID} = squad.${SquadSpot.COLUMN_PLAYER_ID}
        """)
    fun loadSquad(): Cursor
}