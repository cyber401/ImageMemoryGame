package com.example.imagememorygame

enum class MemoryCardProperty(val numOfCard: Int) {
    EASY(8),
    MEDIUM(18),
    DIFFICULT(28);

    fun cardWidth():Int{
        return when(this){
            EASY -> 2
            MEDIUM -> 3
            DIFFICULT -> 4
        }
    }
    fun cardHeight():Int{
        return numOfCard/cardWidth()
    }
    fun pairOfCards():Int{
        return numOfCard/2
    }
}