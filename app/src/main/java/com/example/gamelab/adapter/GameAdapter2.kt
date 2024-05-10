package com.example.gamelab.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gamelab.R
import com.example.gamelab.activity.CatalogActivity
import com.example.gamelab.activity.GamesActivity
import com.example.gamelab.listener.GameAdapterListener
import com.example.gamelab.model.Game

class GameAdapter2(private val list: List<Game>) :
    RecyclerView.Adapter<GameAdapter2.GameViewHolder>() {
    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameName: TextView
        val gamePrice: TextView
        val buttonAddToCart: Button
        val gameLogo: ImageView

        init {
            gameName = itemView.findViewById(R.id.gameName)
            gamePrice = itemView.findViewById(R.id.gamePrice)
            buttonAddToCart = itemView.findViewById(R.id.buttonAddToCart)
            gameLogo = itemView.findViewById(R.id.gameLogo)
        }
    }

    private var listener: GameAdapterListener? = null

    fun setListener(listener: GameAdapterListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.game_item_2, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val item = list[position]

        holder.gameLogo.setImageResource(item.logoResId)
        holder.gameName.text = item.name
        holder.gamePrice.text = "${item.price.toString()}₽"

        holder.buttonAddToCart.setOnClickListener {
            GamesActivity.gameToBuy.remove(item)
            val sum = if (GamesActivity.gameToBuy.isNotEmpty()) GamesActivity.gameToBuy.sumOf { it.price } else 0
            listener?.onItemClick(item, sum)
            notifyDataSetChanged()
        }
    }
}