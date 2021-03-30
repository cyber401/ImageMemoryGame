package com.example.imagememorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var layout1:ConstraintLayout
    private var cardProperty= MemoryCardProperty.MEDIUM
    private val memoryCardGameLogic = MemoryCardGameLogic(cardProperty)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.customRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, cardProperty.cardWidth())
        layout1 = findViewById(R.id.constraint)
        recyclerView.adapter = ImageMemoryAdapter(this, cardProperty, memoryCardGameLogic.memoryCard, object:ImageMemoryAdapter.ImageGameListener{
            override fun onClick(position: Int) {
                    memoryCardGameLogic.handleCardFlip(position)


                /**here "notifyDataSetChanged()" is notifying recycler adapter at that position that there
                 * is some data change in that position plz check again. This action happen every time
                 * when this function run and because of the this "notifyItemChanged() function run"
                 */
                recyclerView.adapter?.notifyDataSetChanged()

            }
        })
    }
}