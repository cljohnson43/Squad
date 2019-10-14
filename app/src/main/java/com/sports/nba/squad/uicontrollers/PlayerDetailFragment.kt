package com.sports.nba.squad.uicontrollers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sports.nba.squad.R
import com.sports.nba.squad.data.Player
import com.sports.nba.squad.utils.Image
import com.sports.nba.squad.viewmodels.PlayerDetailViewModel
import com.sports.nba.squad.viewmodels.PlayerDetailViewModelFactory
import kotlinx.android.synthetic.main.fragment_player_details.view.*

class PlayerDetailFragment : Fragment() {

    private val playerDetailViewModel: PlayerDetailViewModel by lazy {
        activity?.let {
            ViewModelProvider(it, PlayerDetailViewModelFactory(it.application, this.arguments?.getInt(
                Player.ID_KEY))).get(
                PlayerDetailViewModel::class.java
            )
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_player_details, container, false)
        Image.fromUrl(view.iv_big_headshot, playerDetailViewModel.player.largeHeadshotUrl)
        return view
    }
}