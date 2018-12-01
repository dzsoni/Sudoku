@file:JvmName("Sudoku")

import sudoku.*
import java.lang.NullPointerException
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException


fun main(args: Array<String>) {

    if (args.size == 0) {
        throw Exception("\nAddj meg egy fájlnevet.\n")
    }


    var fileR: BufferedReader? = null
    var list: List<String> = emptyList()
    var sT: SudokuTable = SudokuTable()

    try {

        fileR = File(args[0]).bufferedReader()
        // Read the first 9 lines
        list = fileR.useLines { lines: Sequence<String> -> lines.take(9).toList() }

    } catch (e: Exception) {
        println("Error while reading sudoku file.")
        if (fileR != null) {
            fileR.close()
        }
    }

    if (list.firstOrNull() == null) {
        throw Exception("\nÜres sudoku tábla.\n")
    }
    if (list.size != 9) {
        throw Exception("\nKorrupt sudoku tábla.A sorok száma kevés.\n")
    }


    list.forEachIndexed { row,
                          s -> s.splitToSequence(",", limit = 9).forEachIndexed { col, c ->
            sT.table[row][col].setValue(c.toInt())
        }
    }

    //print sudoku tábla
    for(r in 0..8){
        for(c in 0..8){
            print(sT.table[r][c].getValue().toString())
        }
        print("\n")
    }

}