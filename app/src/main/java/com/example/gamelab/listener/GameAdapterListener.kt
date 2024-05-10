package com.example.gamelab.listener

import com.example.gamelab.model.Game

interface GameAdapterListener {
    fun onItemClick(item: Game, sum: Int)
}