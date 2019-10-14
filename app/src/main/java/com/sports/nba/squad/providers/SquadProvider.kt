package com.sports.nba.squad.providers

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.sports.nba.squad.data.PlayersRepo
import java.lang.IllegalArgumentException

private const val TABLE_URI = 1

private val matcher = UriMatcher(UriMatcher.NO_MATCH).apply {
    addURI(SquadProvider.AUTHORITY, "squad", TABLE_URI)
}

class SquadProvider : ContentProvider(){
    private val playersRepo: PlayersRepo by lazy {
        PlayersRepo.getInsance(context!!)
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        when(matcher.match(uri)) {
            TABLE_URI -> {
                return playersRepo.loadSquad()
            }
            else -> throw IllegalArgumentException("Invalid URI")
        }
        return null
    }

    override fun onCreate(): Boolean { return true }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int { return 0 }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return playersRepo.removeFromSquad(ContentUris.parseId(uri))
    }

    override fun getType(uri: Uri): String? = null

    companion object {
        const val AUTHORITY = "com.sports.nba.squad.provider"
    }
}
