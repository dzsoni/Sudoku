import sudoku.*

fun main(args: Array<String>) {
    var sT: SudokuTable = SudokuTable()

    sT.table[0][1].setValue(8)

    var r = sT.getRefToRow(0)!!
    r.forEach {print(it.getValue().toString())}

    println("")
    var s = sT.getRefToColumn(1)!!
    s.forEach { println(it.getValue().toString()) }
    }