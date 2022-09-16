package Ejemplos

import java.io.File
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    println("Introdueix un directori:")
    val ent = BufferedReader(InputStreamReader(System.`in`)).readLine()
    val f = File(ent)
    var value = 0;
    System.out.println("Llista de fitxers i directoris del directori " + ent)
    System.out.println("---------------------------------------------------")
    printList(f)
    }


fun printList(f:File){
    var value = 0;
    System.out.println("Llista de fitxers i directoris del directori " + f.path)
    System.out.println("---------------------------------------------------")
    for (e in f.list().sorted()){
        System.out.println("$value.- $e");
        value++;
    }
}