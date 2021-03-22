package com.example.imagememorygame

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

class ImageMemoryAdapter(private val context:Context) : RecyclerView.Adapter<ImageMemoryAdapter.MemoryGameViewHolder>() {
    companion object{
        private const val MARGIN = 10
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoryGameViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_container, parent, false)

        // help to make flexible recycle view
        val containerParam = view.findViewById<CardView>(R.id.imageButtonCard).layoutParams as ViewGroup.MarginLayoutParams

        val width = parent.width/3-(2* MARGIN)
        val height = parent.height/5-(2* MARGIN)
        val average = min(width, height)
        containerParam.width = average
        containerParam.height = average
        containerParam.setMargins(MARGIN, MARGIN, MARGIN, MARGIN)
        return(MemoryGameViewHolder(view))
    }

    override fun getItemCount() = 15


    override fun onBindViewHolder(holder: MemoryGameViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class MemoryGameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int) {
            imageButton.setOnClickListener {
                Log.d("clicker","$position")
            }
}

    }

}
