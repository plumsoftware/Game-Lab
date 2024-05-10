package com.example.gamelab.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gamelab.R
import com.example.gamelab.activity.CatalogActivity.Companion.gameToBuy
import com.example.gamelab.model.Game

class GameAdapter(private val list: List<Game>) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameName: TextView
        val gameGenre: TextView
        val gamePrice: TextView
        val buttonAddToCart: Button
        val gameLogo: ImageView

        init {
            gameName = itemView.findViewById(R.id.gameName)
            gameGenre = itemView.findViewById(R.id.gameGenre)
            gamePrice = itemView.findViewById(R.id.gamePrice)
            buttonAddToCart = itemView.findViewById(R.id.buttonAddToCart)
            gameLogo = itemView.findViewById(R.id.gameLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val item = list[position]

        holder.gameGenre.text = "Жанр игры: ${item.genre}"
        holder.gameLogo.setImageResource(item.logoResId)
        holder.gameName.text = item.name
        holder.gamePrice.text = "${item.price.toString()}₽"

        if (gameToBuy.contains(item)) {
            holder.buttonAddToCart.text = "Убрать"
        } else {
            holder.buttonAddToCart.text = "В корзину"
        }

        holder.buttonAddToCart.setOnClickListener {
            if (!gameToBuy.contains(item)) {
                gameToBuy.add(item)
                holder.buttonAddToCart.text = "Убрать"
            } else {
                gameToBuy.remove(item)
                holder.buttonAddToCart.text = "В корзину"
            }
        }
    }
}