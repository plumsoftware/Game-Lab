package com.example.gamelab.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamelab.model.Game

class GameGenre(private val list: List<Game>) : RecyclerView.Adapter<GameGenre.GameViewHolder>() {
    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}