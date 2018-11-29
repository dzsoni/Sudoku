import sudoku.*
import java.lang.NullPointerException
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException


fun main(args: Array<String>) {
    var fileReader: BufferedReader? = null
    var list:List<String> = emptyList()

    try {

        var fileReader = BufferedReader(FileReader("proba1.txt"))

        // Read the first 9 lines
        list = fileReader.useLines { lines: Sequence<String> -> lines.take(9).toList() }

    } catch (e: Exception) {
        println("Error while reading sudoku file.")
    } finally {
        try {
            fileReader!!.close()
        } catch (e: IOException) {
            println("Closing fileReader Error!")
            e.printStackTrace()
        }
    }
    
}