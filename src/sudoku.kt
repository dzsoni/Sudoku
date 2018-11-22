import sudoku.*
import java.lang.NullPointerException


fun main(args: Array<String>) {
    var sT = SudokuTable()

    sT.table[0][0].setPossibleNumbers(mutableSetOf(3,4,5))
    var bl = sT.blocks[0][0].block3x3[0][0].getPossibleNumbers()
    bl.forEach { println(it.toString()) }
    sT.table[0][0].getPossibleNumbers().forEach { print(it.toString()) }
    }//teszt