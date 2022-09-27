package Ejercicios

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun main(args: Array<String>) {
    //Root Directory
    val root = File.listRoots()[0];
    var f = root;
    BufferedReader(InputStreamReader(System.`in`))
    var option = 0

    while (option != -1) {
        printList(f)
        println(
            "Introduce a number: \n (0 to go to parent directory) \n" +
                    " (introduce one of the numbers listed to access that directory)\n" +
                    " (-1 to end program)"
        )
        System.out.println("---------------------------------------------------")
        val input = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
        if (input >= 0 && input <= f.listFiles().sorted().lastIndex + 1) {
            if (input == 0) {
                    if (goToParentDir(f)) {
                        f = f.parentFile;
                    }
            } else {
                val f2 = f.listFiles().sorted().get(input - 1)
                if (f2.exists() && f2.isDirectory){
                    if (f2.canRead())
                        f = f2 else println("You don't have the read permission of this Directory")
                } else {
                    println("Not a directory")
                }

            }
        } else println("Please input number between valid range")
        if (input == -1) option = input
    }
}

fun printList(f: File) {
    var num = 1;
    println("List of file and directories in " + f.path)
    println("---------------------------------------------------")
    println("0.- Directori Pare")
    for (e in f.listFiles().sorted()) {
        if (e.isDirectory){
            println("$num.- ${e.name}  <Directory>")
        } else println("$num.- ${e.name}   ${e.length()}")
        num++;
    }
}

fun goToParentDir(fAUX: File): Boolean {
    if (fAUX.parentFile == null) {
        println("Can't go to parent directory cah you're in the root directory")
        return false;
    } else {
        return true;
    }
}




