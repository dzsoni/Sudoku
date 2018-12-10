package sudoku

import java.lang.Exception


class Cella {
    private var listOfPossibleNumbers: MutableSet<Int>  = mutableSetOf(1,2,3,4,5,6,7,8,9) //A cellába mégírható lehetséges számok

    fun sortPossibleNumners() {
        listOfPossibleNumbers=listOfPossibleNumbers.toSortedSet()
    }
    fun getPossibleNumbers():MutableSet<Int>        = listOfPossibleNumbers.toMutableSet()  // copy
    fun getPossibleNumbersByRef():MutableSet<Int>   = listOfPossibleNumbers                 // make a reference
    fun setPossibleNumbers(list:MutableSet<Int>){
        listOfPossibleNumbers=list.toMutableSet()
    }
    fun removePossibleNumber(value: Int):Boolean    = listOfPossibleNumbers.remove(value)
    fun removePossibleNumbersWithList( list: MutableSet<Int>) = listOfPossibleNumbers.removeAll(list)
    fun addPossibleNumber(value: Int){
        if (value in 1..9) {
            listOfPossibleNumbers.add(value)
            listOfPossibleNumbers=listOfPossibleNumbers.toSortedSet()
        }

    }

     fun addPossibleNumbersWithList (list: MutableSet<Int>) {
         var ok = true
         list.forEach { if (it<1 || it>9) {ok=false}  }
         if (ok){
             listOfPossibleNumbers.addAll(list.toMutableSet())
         }

     }
    //Megtart
    fun retainPossibelNumers ( list: MutableSet<Int>){
        list.retainAll(mutableSetOf(1,2,3,4,5,6,7,8,9)) //Safety filtering
        listOfPossibleNumbers.retainAll(list)
    }
    //---------------------------------
     fun setValue(value: Int){
        if(value in 1..9) {
            listOfPossibleNumbers.clear()
            listOfPossibleNumbers.add(value)
        }
        else if(value ==0){
            listOfPossibleNumbers.clear()
            listOfPossibleNumbers.addAll(mutableListOf(1,2,3,4,5,6,7,8,9))
        }
        else{
            throw Exception("\nNem megengedett számot akartál a cellába írni.\n")
        }
    }
     fun getValue():Int {
         return when (listOfPossibleNumbers.count()){
             1 -> listOfPossibleNumbers.first()
             else ->{0}
         }

     }
}


