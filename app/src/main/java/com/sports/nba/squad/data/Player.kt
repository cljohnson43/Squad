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
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    @ColumnInfo(name = Player.COLUMN_FIRST_NAME) val firstName: String,
    @ColumnInfo(name = Player.COLUMN_LAST_NAME) val lastName: String,
    @ColumnInfo(name = Player.COLUMN_BORN) val born: String,
    @ColumnInfo(name = Player.COLUMN_HOMETOWN) val hometown: String,
    @ColumnInfo(name = Player.COLUMN_URL) val url: String,
    @ColumnInfo(name = Player.COLUMN_SMALL_HEADSHOT_URL) val smallHeadshotUrl: String?,
    @ColumnInfo(name = Player.COLUMN_LARGE_HEADSHOT_URL) val largeHeadshotUrl: String?,
    @ColumnInfo(name = Player.COLUMN_TEAM_BRAND_URL) val teamBrandUrl: String?,
    @ColumnInfo(name = Player.COLUMN_BACKGROUND_COLOR) val backgroundColor: String?,
    @ColumnInfo(name = Player.COLUMN_NUMBER) val number: String?,
    @ColumnInfo(name = Player.COLUMN_APG) val apg: String?,
    @ColumnInfo(name = Player.COLUMN_PPG) val ppg: String?,
    @ColumnInfo(name = Player.COLUMN_RPG) val rpg: String?,
    @ColumnInfo(name = Player.COLUMN_TEAM) val team: String?,
    @ColumnInfo(name = Player.COLUMN_LAST_SEASON) val lastSeason: String?
    ) {
    constructor(
        firstName: String,
        lastName: String,
        born: String,
        hometown: String,
        url: String,
        smallHeadshotUrl: String?,
        largeHeadshotUrl: String?,
        teamBrandUrl: String?,
        backgroundColor: String?,
        lastSeason: String?,
        team: String?,
        rpg: String?,
        ppg: String?,
        apg: String?,
        number: String?
    ) : this(
        firstName = firstName,
        lastName = lastName,
        born = born,
        id = null,
        hometown = hometown,
        url = url,
        smallHeadshotUrl = smallHeadshotUrl,
        largeHeadshotUrl = largeHeadshotUrl,
        backgroundColor = backgroundColor,
        teamBrandUrl = teamBrandUrl,
        lastSeason = lastSeason,
        apg = apg,
        rpg = rpg,
        ppg = ppg,
        number = number,
        team = team
    )

    companion object {
        const val TABLE_NAME = "players"
        const val COLUMN_ID = "id"
        const val COLUMN_FIRST_NAME = "first_name"
        const val COLUMN_LAST_NAME = "last_name"
        const val COLUMN_BORN = "born"
        const val COLUMN_HOMETOWN = "hometown"
        const val COLUMN_URL = "url"
        const val COLUMN_SMALL_HEADSHOT_URL = "small_headshot_url"
        const val COLUMN_LARGE_HEADSHOT_URL = "large_headshot_url"
        const val COLUMN_BACKGROUND_COLOR = "background_color"
        const val COLUMN_TEAM_BRAND_URL = "team_brand_url"
        const val COLUMN_NUMBER = "number"
        //const val COLUMN_POSITION = "position"
        const val COLUMN_TEAM = "team"
        const val COLUMN_PPG = "ppg"
        const val COLUMN_APG = "apg"
        const val COLUMN_RPG = "rpg"
        const val COLUMN_LAST_SEASON = "last_season"
        const val ID_KEY = "player_id_key"
    }
}