package Ejercicios

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun main(args: Array<String>) {
    //Root Directory
    val root = File.listRoots()[0];
    var f = root;
    val input = BufferedReader(InputStreamReader(System.`in`))
    var option = "0"

    while (option != "-1") {
        printList(f)
        println(
            "Introduce a number: \n (0 to go to parent directory) \n" +
                    " (introduce one of the numbers listed to access that directory)\n" +
                    " (-1 to end program)"
        )
        System.out.println("---------------------------------------------------")

        val input = BufferedReader(InputStreamReader(System.`in`)).readLine()
        if (input.equals("0")) {
            if (f.exists() && f.isDirectory()) {
                if (goToParentDir(f)) {
                    f = f.parentFile;
                }
            } else
                println("Not a directory")
        } else {
            println("Directory does not exist")

        }
    }
}


fun printList(f: File) {
    var num = 0;
    System.out.println("List of file and directories in " + f.path)
    System.out.println("---------------------------------------------------")
    for (e in f.listFiles().sorted()) {
        System.out.println("$num.- $e");
        num++;
    }
}

fun goToParentDir(f: File): Boolean {
    if (f.parent == null) {
        println("Can't go to parent directory cah you're in the root directory")
        return false;
    } else {
        return true;
    }
}



