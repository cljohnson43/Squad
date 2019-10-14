package com.sports.nba.squad.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sports.nba.squad.R
import com.sports.nba.squad.data.Player
import com.sports.nba.squad.utils.Image

class SquadWidgetAdapter :
    ListAdapter<Player, SquadWidgetAdapter.SquadViewModel>(SquadDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquadViewModel {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_player_widget, parent, false)
        return SquadViewModel(view)
    }

    override fun onBindViewHolder(holder: SquadViewModel, position: Int) {
        Image.fromUrl(holder.ivHeadshot, getItem(position).smallHeadshotUrl!!)
    }

    class SquadViewModel(view: View) : RecyclerView.ViewHolder(view) {
        val ivHeadshot: ImageView = view.findViewById(R.id.iv_headshot)
    }
}

private class SquadDiffUtil : DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.smallHeadshotUrl == newItem.smallHeadshotUrl
    }
}