package com.example.imagememorygame

data class MemoryCard(
        val identifier:Int,
        var upSided:Boolean = false,
        var cardMatched:Boolean = false
)