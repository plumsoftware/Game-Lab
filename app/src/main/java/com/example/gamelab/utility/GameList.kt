package com.example.gamelab.utility

import com.example.gamelab.R
import com.example.gamelab.model.Game

val gameList: List<Game> = listOf(
    Game(
        id = 0,
        price = 2099,
        name = "Far cry 6",
        logoResId = R.drawable.img1,
        genre = "Шутер от первого лица"
    ),
    Game(
        id = 1,
        price = 700,
        name = "Rocket League",
        logoResId = R.drawable.img2,
        genre = "аркада, футбол"
    ),
    Game(
        id = 2,
        price = 459,
        name = "Machinarium",
        logoResId = R.drawable.img3,
        genre = "point-and-click"
    ),
    Game(
        id = 3,
        price = 914,
        name = "Phasmophobia",
        logoResId = R.drawable.img4,
        genre = "survival horror"
    ),
    Game(
        id = 4,
        price = 2099,
        name = "Astroneer",
        logoResId = R.drawable.img5,
        genre = "песочница, приключенческая игра"
    ),
)