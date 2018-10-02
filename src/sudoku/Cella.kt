package sudoku


class Cella {
    private var listOfPossibleNumbers: MutableSet<Int>  = mutableSetOf(1,2,3,4,5,6,7,8,9) //A cellába mégírható lehetséges számok

    fun sortPossibleNumners() {
        listOfPossibleNumbers=listOfPossibleNumbers.toSortedSet()
    }
    fun getPossibleNumbers():MutableSet<Int>        = listOfPossibleNumbers.toMutableSet()  // copy
    fun removePossibleNumber(value: Int):Boolean    = listOfPossibleNumbers.remove(value)
    fun addPossibleNumber(value: Int){
        if (value>0 && value <10) {
            listOfPossibleNumbers.add(value)
            listOfPossibleNumbers=listOfPossibleNumbers.toSortedSet()
        }

    }
     fun removePossibleNumbersWithList( list: MutableSet<Int>) = listOfPossibleNumbers.removeAll(list)
     fun addPossibleNumbersWithList (list: MutableSet<Int>) {
         var ok = true
         list.forEach { n->  if (n<1 || n>9) {ok=false}  }
         if (ok){
             listOfPossibleNumbers.addAll(list.toMutableSet())
         }

     }
     fun setValue(value: Int):Unit{
        if(value >0 && value <10) {
            listOfPossibleNumbers.clear()
            listOfPossibleNumbers.add(value)
        }
        if(value ==0){
            listOfPossibleNumbers.clear()
            listOfPossibleNumbers.addAll(mutableListOf(1,2,3,4,5,6,7,8,9))
        }
    }
     fun getValue():Int {
         when (listOfPossibleNumbers.count()){
             1 -> return listOfPossibleNumbers.first()
             else ->{return 0}
         }

     }
}
