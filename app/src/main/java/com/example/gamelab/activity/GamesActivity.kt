package com.example.gamelab.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamelab.R
import com.example.gamelab.adapter.GameAdapter2
import com.example.gamelab.listener.GameAdapterListener
import com.example.gamelab.model.Game

class GamesActivity : AppCompatActivity() {

    companion object {
        var gameToBuy: MutableList<Game> = mutableListOf()
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        val homeBtn = findViewById<ImageButton>(R.id.buttonHome)
        val buttonPay = findViewById<Button>(R.id.buttonPay)
        val textViewPrice = findViewById<TextView>(R.id.textViewPrice)
        val recyclerGames = findViewById<RecyclerView>(R.id.recyclerGames)

        gameToBuy = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableArrayListExtra("games", Game::class.java)?.toMutableList()
                ?: CatalogActivity.gameToBuy
        } else {
            CatalogActivity.gameToBuy
        }

        var adapter = GameAdapter2(gameToBuy)
        val listener = object : GameAdapterListener {
            override fun onItemClick(item: Game, sum: Int) {
//                gameToBuy.remove(item)
//                adapter = GameAdapter2(gameToBuy)
//
//                recyclerGames.layoutManager =
//                    LinearLayoutManager(this@GamesActivity, LinearLayoutManager.VERTICAL, false)
//                recyclerGames.adapter = adapter

                Log.i("TAG", sum.toString())

                textViewPrice.text = "${sum}₽"
            }
        }

        adapter.setListener(listener)
        recyclerGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerGames.adapter = adapter

        textViewPrice.text = "${gameToBuy.sumOf { it.price }}₽"

        homeBtn.setOnClickListener {
            onBackPressed()
        }
        buttonPay.setOnClickListener {
            startActivity(Intent(this, PayActivity::class.java))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startNew()
    }

    private fun startNew() {
        startActivity(Intent(this, CatalogActivity::class.java).apply {
            val array = arrayListOf<Game>()
            array.addAll(CatalogActivity.gameToBuy)
            putParcelableArrayListExtra("games", array)
        })
    }
}