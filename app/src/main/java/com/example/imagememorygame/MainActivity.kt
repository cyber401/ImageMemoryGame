package com.example.imagememorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var cardProperty= MemoryCardProperty.EASY
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.customRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, cardProperty.cardWidth())
        val memoryCardGameLogic = MemoryCardGameLogic(cardProperty)
        recyclerView.adapter = ImageMemoryAdapter(this, cardProperty, memoryCardGameLogic.memoryCard, object:ImageMemoryAdapter.ImageGameListener{
            override fun onClick(position: Int) {
                    Log.i("lalit", "MainActivity position = $position")

            }
        })
    }
}