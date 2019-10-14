package com.sports.nba.squad.uicontrollers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sports.nba.squad.R
import com.sports.nba.squad.adapters.PlayersAdapter
import com.sports.nba.squad.data.Player
import com.sports.nba.squad.utils.Logger
import com.sports.nba.squad.viewmodels.PlayersViewModel

class PlayersActivity : AppCompatActivity(), PlayersAdapter.PlayerSelector {

    private val playersViewModel: PlayersViewModel by lazy {
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

        subscribeUi()
    }

    override fun onPlayerSelected(player: Player) {
        supportFragmentManager.beginTransaction().apply {
            val args = Bundle().apply { putInt(Player.ID_KEY, player.id!!) }
            val detailFragment = PlayerDetailFragment().apply { arguments = args }
            replace(R.id.fl_fragment_container, detailFragment)
            addToBackStack(null)
            commit()
        }
    }

    fun subscribeUi() {
        playersViewModel.getSquad().observe(this, Observer { squadList ->
            squadList?.forEach {
                Logger.log(it.toString())
            }
        })
    }

    fun onClick() {
        Logger.log("Click handled by PlayersActivity")
    }
}
