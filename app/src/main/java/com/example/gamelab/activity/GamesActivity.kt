package com.example.gamelab.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamelab.R
import com.example.gamelab.adapter.GameAdapter2
import com.example.gamelab.listener.GameAdapterListener

class GamesActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        val homeBtn = findViewById<ImageButton>(R.id.buttonHome)
        val buttonPay = findViewById<Button>(R.id.buttonPay)
        val textViewPrice = findViewById<TextView>(R.id.textViewPrice)
        val recyclerGames = findViewById<RecyclerView>(R.id.recyclerGames)

        var adapter = GameAdapter2(CatalogActivity.gameToBuy)
        adapter.setListener(object : GameAdapterListener {
            override fun onItemClick() {
                textViewPrice.text = "${CatalogActivity.gameToBuy.sumOf { it.price }}"
                adapter = GameAdapter2(CatalogActivity.gameToBuy)
                recyclerGames.layoutManager =
                    LinearLayoutManager(this@GamesActivity, LinearLayoutManager.VERTICAL, false)
                recyclerGames.adapter = adapter
            }
        })
        recyclerGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerGames.adapter = adapter

        textViewPrice.text = "${CatalogActivity.gameToBuy.sumOf { it.price }}₽"

        homeBtn.setOnClickListener {
            finish()
        }
        buttonPay.setOnClickListener {
            startActivity(Intent(this, PayActivity::class.java))
        }
    }
}