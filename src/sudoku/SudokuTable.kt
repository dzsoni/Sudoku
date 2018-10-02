package sudoku

class SudokuTable {
    //Sudoku table
    var table = Array<Array<Cella>>(9) { Array<Cella>(9) { Cella() } }

    private var coltable = Array<Array<Cella>>(9) { Array<Cella>(9) { Cella() } }

    init{
        for (c in 0..8){
            for (r in 0..8){
                coltable[c][r]=table[r][c]
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
        if (col<0 || col> coltable.size-1){
            return null
        }
        return coltable[col]
    }


}