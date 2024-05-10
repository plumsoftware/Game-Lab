package com.example.gamelab.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.gamelab.R
import com.example.gamelab.adapter.GameAdapter
import com.example.gamelab.model.Game
import com.example.gamelab.utility.gameList

class CatalogActivity : AppCompatActivity() {

    companion object {
        var gameToBuy = mutableListOf<Game>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        gameToBuy = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableArrayListExtra("games", Game::class.java)?.toMutableList() ?: mutableListOf()
        } else {
            val i: ArrayList<Game> = intent.getParcelableArrayListExtra("games")!!
            i.toMutableList()
        }

        val recyclerGames = findViewById<RecyclerView>(R.id.recyclerGames)
        val buttonCart = findViewById<ImageButton>(R.id.buttonCart)
        val buttonSave = findViewById<Button>(R.id.buttonSave)

        val adapter = GameAdapter(gameList)

        recyclerGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerGames.adapter = adapter

        buttonSave.setOnClickListener {
            startActivity(Intent(this, GamesActivity::class.java).apply {
                val array = arrayListOf<Game>()
                array.addAll(gameToBuy)
                putParcelableArrayListExtra("games", array)
            })
            finish()
        }
        buttonCart.setOnClickListener {
            startActivity(Intent(this, GamesActivity::class.java))
            finish()
        }
    }
}