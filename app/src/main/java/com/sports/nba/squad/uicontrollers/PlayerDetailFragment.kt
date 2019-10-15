package com.sports.nba.squad.uicontrollers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sports.nba.squad.R
import com.sports.nba.squad.data.Player
import com.sports.nba.squad.databinding.FragmentPlayerDetailsBinding
import com.sports.nba.squad.utils.Image
import com.sports.nba.squad.viewmodels.PlayerDetailViewModel
import com.sports.nba.squad.viewmodels.PlayerDetailViewModelFactory

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
        //val view = inflater.inflate(R.layout.fragment_player_details, container, false)
        val binding: FragmentPlayerDetailsBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_player_details,
            container,
            false
        )
        binding.player = playerDetailViewModel.player
        Image.fromUrl(binding.ivBigHeadshot, binding.player?.largeHeadshotUrl)
        Image.fromUrl(binding.ivTeamLogo, binding.player?.teamBrandUrl)
        binding.fabAddPlayer?.apply {
            setOnClickListener {
                this@PlayerDetailFragment.playerDetailViewModel.addPlayerToSquad()
                Toast.makeText(
                    this@PlayerDetailFragment.context,
                    "${binding.player?.firstName} ${binding.player?.lastName} added to your Squad",
                    Toast.LENGTH_SHORT
                ).show()
                hide()
            }
        }
        return binding.root
    }
}