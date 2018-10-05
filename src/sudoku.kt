import sudoku.*


fun main(args: Array<String>) {
    var sT = SudokuTable()
    sT.table[0][1].setValue(8)

    var copysT =SudokuTable(sT)//copy of sT

    sT.table[0][1].setValue(5)

    var r = sT.getRefToRow(0)!!
    r.forEach {print(it.getValue().toString())}

    println("")
    var s = sT.getRefToColumn(1)!!
    s.forEach { println(it.getValue().toString()) }


    //copy of sT
    println("")
    var ss = copysT.getRefToColumn(1)!!
    ss.forEach { println(it.getValue().toString()) }



    }