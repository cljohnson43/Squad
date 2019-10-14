package com.sports.nba.squad.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = SquadSpot.TABLE_NAME, foreignKeys = arrayOf(
        ForeignKey(
            entity = Player::class,
            parentColumns = arrayOf(Player.COLUMN_ID),
            childColumns = arrayOf(SquadSpot.COLUMN_PLAYER_ID)
        )
    )
)
class SquadSpot private constructor(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = SquadSpot.COLUMN_PLAYER_ID) val playerId: Long?
) {
    constructor(playerId: Long) : this(id = null, playerId = playerId)

    companion object {
        const val TABLE_NAME = "squad"
        const val COLUMN_PLAYER_ID = "player_id"
    }
}