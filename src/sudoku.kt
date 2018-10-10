import sudoku.*
import java.lang.NullPointerException


fun main(args: Array<String>) {
    var sT = SudokuTable()


    sT.table[0][1].setValue(4)

    sT.getRefToColumn(2).forEach { println(it.getValue().toString())}

    var ccol = sT.getCopyOfColumn(1)

    sT.table[0][1].setValue(8)
    ccol.forEach {println(it.getValue().toString())}

    }