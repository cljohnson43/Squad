package com.sports.nba.squad.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sports.nba.squad.R
import com.sports.nba.squad.data.Player
import com.sports.nba.squad.utils.Image

class PlayersAdapter(val delegator: PlayerSelector) :
    ListAdapter<Player, PlayersAdapter.PlayersViewHolder>(PlayerDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_player, parent, false)
        return PlayersViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayersViewHolder, position: Int) {
        getItem(position).also {
            holder.tvPlayerName.text = "${it.firstName} ${it.lastName}"
            Image.fromUrl(holder.ivPlayerHeadshot, it.smallHeadshotUrl)
            holder.clViewGroup.setOnClickListener { view ->
                delegator.onPlayerSelected(it)
            }
        }
    }

    class PlayersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvPlayerName: TextView = view.findViewById(R.id.tv_player_name)
        val ivPlayerHeadshot: ImageView = view.findViewById(R.id.iv_player_headshot)
        val clViewGroup: ConstraintLayout = view.findViewById(R.id.cl_player_list_item)
    }

    interface PlayerSelector {
        fun onPlayerSelected(player: Player)
    }
}

private class PlayerDiffUtil : DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.firstName == newItem.firstName && oldItem.lastName == newItem.lastName
    }
}