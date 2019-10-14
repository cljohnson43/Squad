package com.sports.nba.squad.uicontrollers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sports.nba.squad.R
import com.sports.nba.squad.data.Player
import com.sports.nba.squad.utils.Image
import com.sports.nba.squad.viewmodels.PlayerDetailViewModel
import com.sports.nba.squad.viewmodels.PlayerDetailViewModelFactory
import kotlinx.android.synthetic.main.fragment_player_details.view.*

class PlayerDetailFragment : Fragment() {

    private val playerDetailViewModel: PlayerDetailViewModel by lazy {
        activity?.let {
            val playerId = this.arguments?.getLong(Player.ID_KEY)
            ViewModelProvider(it, PlayerDetailViewModelFactory(it.application)).get(
                PlayerDetailViewModel::class.java
            ).apply {
                setPlayer(playerId!!)
            }

        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_player_details, container, false)
        Image.fromUrl(view.iv_big_headshot, playerDetailViewModel.player?.largeHeadshotUrl)
        view.findViewById<FloatingActionButton>(R.id.fab_add_player)?.apply {
            setOnClickListener {
                this@PlayerDetailFragment.playerDetailViewModel.addPlayerToSquad()
                val player = this@PlayerDetailFragment.playerDetailViewModel.player
                Toast.makeText(
                    this@PlayerDetailFragment.context,
                    "${player?.firstName} ${player?.lastName} added to your Squad",
                    Toast.LENGTH_SHORT
                ).show()
                hide()
            }
        }
        return view
    }
}