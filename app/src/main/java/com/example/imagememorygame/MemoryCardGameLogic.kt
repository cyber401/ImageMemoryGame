package com.example.imagememorygame

class MemoryCardGameLogic(memoryCardProperty: MemoryCardProperty){
     private val list = defaultImages.shuffled().take(memoryCardProperty.pairOfCards())
     private val imageList = (list + list).shuffled()
     val memoryCard = imageList.map { MemoryCard(it) }
}