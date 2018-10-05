import sudoku.*


fun main(args: Array<String>) {
    var sT = SudokuTable()
    sT.table[0][1].setValue(8)

    var copysT =SudokuTable(sT)//copy of sT

    sT.table[0][1].setValue(5)

    var r = sT.getRefToRow(0)!!
    r.forEach {print(it.getValue().toString())}

    println("")
     var t = copysT.getRefToRow(0)!!
     t.forEach {print(it.getValue().toString())}
    }