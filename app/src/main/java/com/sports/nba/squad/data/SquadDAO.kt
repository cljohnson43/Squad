package com.sports.nba.squad.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SquadDAO {
    @Delete
    fun deleteFromSquad(squadSpot: SquadSpot): Int

    @Insert
    fun insertToSquad(squadSpot: SquadSpot): Unit

    @Query("SELECT * FROM ${SquadSpot.TABLE_NAME}")
    fun getSquad(): LiveData<List<SquadSpot>>
}