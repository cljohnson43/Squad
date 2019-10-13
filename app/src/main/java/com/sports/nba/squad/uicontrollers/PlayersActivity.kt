package com.sports.nba.squad.uicontrollers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sports.nba.squad.R
import com.sports.nba.squad.viewmodels.PlayersViewModel

class PlayersActivity : AppCompatActivity() {

    private val playersViewModel: ViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
            PlayersViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.fl_fragment_container, PlayerListFragment())
            commit()
        }
    }
}
