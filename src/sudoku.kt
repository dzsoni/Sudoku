@file:JvmName("Sudoku")

import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Options
import sudoku.SudokuTable
import java.io.BufferedReader
import java.io.File


fun main(args: Array<String>) {

    var list: List<String> = emptyList()
    var sT: SudokuTable = SudokuTable()

    //Apache Commons CLI
    var options = Options()
    var parser = DefaultParser()
    //Make an option -f with filname argument
    options.addOption("f", true, "Name of the sudoku table file.")
    var cmd = parser.parse(options, args)

    if (cmd.hasOption("f")) {
        var fileR: BufferedReader? = null
        try {

            fileR = File(cmd.getOptionValue("f")).bufferedReader()
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
                              s ->
            s.splitToSequence(",", limit = 9).forEachIndexed { col, c ->
                sT.table[row][col].setValue(c.toInt())
            }
        }

    } else {
        throw Exception("\nAdj meg egy file nevet.\n")
    }


    //print sudoku table
    for (r in 0..8) {
        for (c in 0..8) {
            print(sT.table[r][c].getValue().toString())
        }
        print("\n")
    }

}