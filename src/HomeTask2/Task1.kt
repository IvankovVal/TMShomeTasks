package HomeTask2

import com.sun.beans.introspect.ClassInfo.clear
import kotlin.system.exitProcess

/*
* 1.
Напишите программу, которая вычисляет периметр и площадь
прямоугольника. Длина и ширина прямоугольника вводятся с
клавиатуры.
* */
fun getPandSOfRectangle(length:Int, width:Int){
    println("Площадь прямоугольника - ${length*width}")
    println("Периметр прямоугольника - ${2*length+2*width}")
}

/*
* Напишите программу, которая принимает на вход баллы студента и
выводит оценку по шкале:
•
Оценка A: от 90 до 100 баллов.
•
Оценка B: от 75 до 89 баллов.
•
Оценка C: от 50 до 74 баллов.
•
Оценка D: от 30 до 49 баллов.
•
Оценка F: от 0 до 29 баллов.
* */
fun end(){
    println("Продолжить проверку проверку - 1")
    println("Закрыть программу - 2")
    val answer = readln().toIntOrNull() ?: 0
    if (answer == 1){
        // clear()
    }
    else exitProcess(0)
}

fun getRating(balls: Int)= when{
    balls in 90..100 -> "Оценка A"
    balls in 75..89 -> "Оценка B"
    balls in 50..74 -> "Оценка C"
    balls in 30..49 -> "Оценка D"
    balls in 0..29 -> "Оценка F"
    else -> "Данные не корректны"

}

/*
* 3. Напишите программу, которая выводит таблицу умножения для числа N, где
N вводится с клавиатуры. Например, если N = 3, программа должна вывести:
3*1=3
3*2=6
3*3=9
3 * 4 = 12
* */

/*
* Напишите программу, которая вычисляет n-е число в последовательности
Фибоначчи. Числа Фибоначчи — это последовательность, в которой каждое
следующее число является суммой двух предыдущих. Первые два числа
равны 0 и 1. N вводится с клавиатуры.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34 .
* */
fun getFibonaccy(number: Int): Int{
    if (number<1)return 0
    if (number == 1) return 0
    if ( number == 2) return 1
    var firstNum = 0
    var secondNum = 1
    var currentNum = 0
    for (i in 2..number){
        currentNum = firstNum + secondNum
        firstNum = secondNum
        secondNum = currentNum
    }
    return currentNum
}

fun getMultyTable(number: Int): String{
    var result: String = ""
    for (i in 1..10){
        result += "\n$number * $i  = ${number * i}"
    }
    return result
}

fun main() {
    println("-=Задание 1=-")

    println("Введите длину прямоугольника")
    val length: Int = readln().toIntOrNull() ?: 0
    println("Введите ширину прямоугольника")
    val width: Int = readln().toIntOrNull() ?: 0

    getPandSOfRectangle(length,width)

    //конец
    end()

    println("-=Задание 2=-")
    println("Введите баллы")
    val balls:Int = readln().toIntOrNull() ?: 0
    println(getRating(balls))

    end()

    println("-=Задание 3=-")
    println("Введите число")
    val numForTable: Int = readln().toIntOrNull() ?: 0
    println(getMultyTable(numForTable))

    end()

    println("-=Задание 4=-")
    println("Введите число")
    val fiboNum: Int = readln().toIntOrNull() ?: 0
    println(getFibonaccy(fiboNum))



}