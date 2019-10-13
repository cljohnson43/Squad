package com.sports.nba.squad.uicontrollers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.*
import com.sports.nba.squad.R
import com.sports.nba.squad.adapters.PlayersAdapter
import com.sports.nba.squad.data.Player
import com.sports.nba.squad.viewmodels.PlayersViewModel
import kotlinx.android.synthetic.main.fragment_player_list.*

class PlayerListFragment : Fragment() {

    private val playersViewModel: PlayersViewModel by lazy {
        activity?.let {
            ViewModelProvider(it, ViewModelProvider.AndroidViewModelFactory(it.application)).get(
                PlayersViewModel::class.java
            )
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = PlayersAdapter()
        rv_players.adapter = adapter
        rv_players.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        subscribeUi(adapter)
    }

    fun subscribeUi(adapter: PlayersAdapter) {
        playersViewModel.getAllPlayers().observe(this, Observer { adapter.submitList(it) })
    }
}