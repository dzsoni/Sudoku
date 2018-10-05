package sudoku

class SudokuTable () {
    //Sudoku table
    var table = Array<Array<Cella>>(9) { Array<Cella>(9) { Cella() } }

    private var colTable = Array<Array<Cella>>(9) {  Array<Cella>(9){ Cella() } }

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
                this.table[r][c].addPossibleNumbersWithList(mutableSetOf(1,2,3,4,5,6,7,8,9))
                this.table[r][c].getPossibleNumbers().retainAll(original.table[r][c].getPossibleNumbers())
            }
        }
    }

    fun getRefToRow(row : Int):Array<Cella>?{
        if (row <0 || row> table.size-1){
            return null
        }
        return table[row]
    }
    fun getRefToColumn(col:Int):Array<Cella>?{
        if (col<0 || col> colTable.size-1){
            return null
        }
        return colTable[col]
    }


}