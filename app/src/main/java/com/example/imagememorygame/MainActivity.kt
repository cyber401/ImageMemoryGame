package com.example.imagememorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var cardProperty= MemoryCardProperty.DIFFICULT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.customRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, cardProperty.cardWidth())

        //shuffled() function work as a name suggest
        val list = defaultImages.shuffled().take(cardProperty.pairOfCards())
        val imageList = (list + list).shuffled()
        recyclerView.adapter = ImageMemoryAdapter(this, cardProperty, imageList)
    }
}