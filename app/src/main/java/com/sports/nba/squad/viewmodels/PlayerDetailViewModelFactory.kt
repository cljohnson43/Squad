package com.sports.nba.squad.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sports.nba.squad.data.Player

class PlayerDetailViewModelFactory(
    private val application: Application,
    private val id: Int?
) : ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlayerDetailViewModel(application = application, playerId = id) as T
    }
}