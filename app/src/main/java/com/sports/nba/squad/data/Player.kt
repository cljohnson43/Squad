package com.sports.nba.squad.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// The data is of the form:

//{"first_name": "Talen",
// "last_name": "Horton-Tucker",
// "born": "11/25/2000",
// "hometown": "Chicago, IL",
// "league": "nba",
// "url": "https://www.foxsports.com/nba/talen-horton-tucker-player-stats",
// "number": "5",
// "position": ["Shooting Guard"],
// "team": "Los Angeles Lakers",
// "head_shot": "#",
// "ppg": null,
// "rpg": null,
// "apg": null,
// "last_season": null},

@Entity(tableName = Player.TABLE_NAME)
data class Player private constructor(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = Player.COLUMN_FIRST_NAME) val firstName: String,
    @ColumnInfo(name = Player.COLUMN_LAST_NAME) val lastName: String,
    @ColumnInfo(name = Player.COLUMN_BORN) val born: String,
    @ColumnInfo(name = Player.COLUMN_HOMETOWN) val hometown: String,
    @ColumnInfo(name = Player.COLUMN_URL) val url: String,
    @ColumnInfo(name = Player.COLUMN_HEAD_SHOT_URL) val headshotURL: String?
) {
    constructor(
        firstName: String,
        lastName: String,
        born: String,
        hometown: String,
        url: String,
        headshotURL: String?
    ) : this(
        firstName = firstName,
        lastName = lastName,
        born = born,
        id = null,
        hometown = hometown,
        url = url,
        headshotURL = headshotURL
    )

    companion object {
        const val TABLE_NAME = "players"
        const val COLUMN_FIRST_NAME = "first_name"
        const val COLUMN_LAST_NAME = "last_name"
        const val COLUMN_BORN = "born"
        const val COLUMN_HOMETOWN = "hometown"
        const val COLUMN_URL = "url"
        const val COLUMN_HEAD_SHOT_URL = "head_shot"

        /*const val COLUMN_NUMBER = "number"
        const val COLUMN_POSITION = "position"
        const val COLUMN_TEAM = "team"
        const val COLUMN_PPG = "ppg"
        const val COLUMN_APG = "apg"
        const val COLUMN_RPG = "rpg"
        const val COLUMN_LAST_SEASON = "last_season"

         */
    }
}