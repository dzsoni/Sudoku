package sudoku

import java.util.*

class SudokuTable () {
    //Sudoku table
    var table = Array<Array<Cella>>(9) { Array<Cella>(9) { Cella() } }

    private var colTable = Array<Array<Cella>>(9) { Array<Cella>(9){Cella()}}
    var block = Array<Array<Cella>>( 3 ) { Array<Cella>(3){Cella()}}


    init{
        for (c in 0..8){
            for (r in 0..8){
                colTable[c][r]=table[r][c]
            }
        }
    }

    constructor(original:SudokuTable):this(){
        for(r in 0..8){
            for(c in 0..8){
                this.table[r][c].setPossibleNumbers(original.table[r][c].getPossibleNumbers())
            }
        }
    }

    fun getRefToRow(row : Int):Array<Cella>{
        require((row>=0 && row < table.size)) {"Az array határokon átléptél"}
        return table[row]
    }
    fun getCopyOfRow(row :Int):Array<Cella>{
        require((row>=0 && row < table.size)) {"Az array határokon átléptél"}
        var dest =  Array<Cella>(9) { Cella() }
        table[row].forEachIndexed { index, cella -> dest[index].setPossibleNumbers(cella.getPossibleNumbers())  }
        return dest
    }
    fun getRefToColumn(col:Int):Array<Cella>{
        require((col>=0 && col < table.size)) {"Az array határokon átléptél."}
        return colTable[col]
    }
    fun getCopyOfColumn(col :Int):Array<Cella>{
        require((col>=0 && col < table.size)) {"Az array határokon átléptél."}
        var dest =  Array<Cella>(9) { Cella() }
        colTable[col].forEachIndexed { index, cella -> dest[index].setPossibleNumbers(cella.getPossibleNumbers())  }
        return dest
    }
}