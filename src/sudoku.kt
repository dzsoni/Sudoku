import sudoku.*
import java.lang.NullPointerException
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException


fun main(args: Array<String>) {
    var fileReader: BufferedReader? = null

    try {

        var line: String?

        var fileReader = BufferedReader(FileReader("proba1.txt"))

        // Read the file line by line
        fileReader.useLines { Charsets.UTF_8, ( println(it)) }


        // Integer.parseInt(tokens[CUSTOMER_AGE]


        line = fileReader.readLine()


    } catch (e: Exception) {
        println("Reading CSV Error!")
        e.printStackTrace()
    } finally {
        try {
            fileReader!!.close()
        } catch (e: IOException) {
            println("Closing fileReader Error!")
            e.printStackTrace()
        }
    }
}