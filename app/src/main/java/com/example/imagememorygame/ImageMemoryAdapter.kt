package com.example.imagememorygame

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

class ImageMemoryAdapter(private val context: Context, private var cardProperty: MemoryCardProperty,  val imageList: List<MemoryCard>,
val cardListener:ImageGameListener) : RecyclerView.Adapter<ImageMemoryAdapter.MemoryGameViewHolder>() {
    companion object{
        private const val MARGIN = 10
    }
    interface ImageGameListener{
       fun onClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoryGameViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_container, parent, false)

        // help to make flexible recycle view
        val containerParam = view.findViewById<CardView>(R.id.imageButtonCard).layoutParams as ViewGroup.MarginLayoutParams

        val width = parent.width/cardProperty.cardWidth()-(2* MARGIN)
        val height = parent.height/cardProperty.cardHeight()-(2* MARGIN)
        val average = min(width, height)
        containerParam.width = average
        containerParam.height = average
        containerParam.setMargins(MARGIN, MARGIN, MARGIN, MARGIN)
        return(MemoryGameViewHolder(view))
    }

    override fun getItemCount() = cardProperty.numOfCard

    override fun onBindViewHolder(holder: MemoryGameViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class MemoryGameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int) {
            imageButton.setImageResource(if(!imageList[position].upSided)
            {
                R.drawable.ic_launcher_background
            }else{
                imageList[position].identifier
            })

            /**here we using listener because we don't wanna use logic here for button rather we use
                in a MainActivity that is a better practise because RecyclerView Adapter work is
                only pass data between MainActivity to RecyclerView.
             */
            imageButton.setOnClickListener {
                cardListener.onClick(position)
                Log.i("lalit", "adapter position = $position")
            }
}

    }

}
