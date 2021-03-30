package com.example.imagememorygame
class MemoryCardGameLogic(private val memoryCardProperty: MemoryCardProperty){
     val memoryCard:List<MemoryCard>
     var matched:Boolean = false
     private var firstCard: Int? = null
     init{
          val list = defaultImages.shuffled().take(memoryCardProperty.pairOfCards())
          val imageList = (list + list).shuffled()
          memoryCard = imageList.map { MemoryCard(it) }
     }

     fun handleCardFlip(position: Int) {
         if(firstCard == null){
             restore()
             firstCard = position
         }else{
             matched = cardIsMatched(position,firstCard!!)
             firstCard = null
         }
         memoryCard[position].upSided = !memoryCard[position].upSided
         }

    private fun cardIsMatched(position: Int, firstCard: Int): Boolean {
            if(memoryCard[position].identifier!=memoryCard[firstCard].identifier){
                return false
    }
        memoryCard[position].cardMatched=true
        memoryCard[firstCard].cardMatched=true
        return true
}

    private fun restore(){
        for(i in memoryCard){
            if(!i.cardMatched) {
                i.upSided = false
            }
                        }
    }
}
