package HomeTask3

import kotlin.system.exitProcess

/*Задача 1: Число палиндром
Напишите программу, которая проверяет, является ли введённое
пользователем число палиндромом (читается одинаково слева направо и
справа налево). Используйте цикл для разбиения числа и сравнения цифр.*/
fun polydromeCheck() {
    println("Введите число для проверки")
    var number: Int = readln().toIntOrNull() ?: 0
    when(number){
        in 0..9 -> println("Ваше число палиндром, как не крути")
        in 10..99 ->{
            if (number/10 == number % 10) println("Ваше число палиндром, как не крути")
            else println("Ваше число не палиндром")
        }
        in 100..999 ->{
            if (number/100 == number % 10) println("Ваше число палиндром, как не крути")
            else println("Ваше число не палиндром")
        }
        in 1000..9999 ->{
            val t: Int = number/1000
            val h: Int = (number - t*1000) / 100
            val d: Int = (number - t*1000 - h*100) / 10
            val o: Int = number % 10
            if (t == o && h == d) println("Ваше число палиндром, как не крути")
            else println("Ваше число не палиндром")
        }
        in 10_000..Int.MAX_VALUE -> {
            val stringNum: String = number.toString()
            if (stringNum == stringNum.reversed())println("Ваше число палиндром, как не крути")
            else println("Ваше число не палиндром")
        }


    }
}


/*Задача 2: Проверка простого числа
Попросите пользователя ввести число и определите, является ли оно
простым. Простое число — это число, которое делится только на 1 и само
на себя. Используйте цикл для проверки всех возможных делителей.*/
fun isPrimeNumber() {
    var answerBool: Boolean = true
    println("Введите число для проверки")
    var number: Int = readln().toIntOrNull() ?: 0
    if (number < 0)
    {
        println("Вы ввели отрицательное число, но ...")
        number *= (-1)
    }
    if (number == 0) println("Вы ввели 0")
    else if (number == 1) println("Вы ввели 1")
    else if (number == 2) println("Вы ввели 2. Это простое число.")
    else{
        var counter = 2
        while (number > counter)  {
            if (number % counter == 0) answerBool = false
            counter = counter + 1
        }
    }
    println(if (answerBool) "$number - простое число" else "$number - составное число")

}


/*Задача 3: Вычисление суммы цифр числа до единичного разряда
Напишите программу, которая принимает на вход положительное число
и находит сумму его цифр, повторяя процесс, пока результат не станет
однозначным числом (например, для 9875: 9+8+7+5 = 29, затем 2+9 = 11, и,
наконец, 1+1 = 2).*/
fun digitsSum() {
        println("Введите число для сложения цифр")
    var number: Int = readln().toIntOrNull() ?: 0
    fun pressNumber(){
        val strNum: String = number.toString()
        var sum:Int = 0
        for (i in strNum){
            sum += i.toString().toInt()
        }
        number = sum

    }
    while (number>9){
        pressNumber()
    }
    println("Число сжато до $number")


}

/*Задача 4: Перевёрнутая лесенка
Напишите программу, которая выводит перевёрнутую лесенку из символов #
высотой N. Пользователь вводит высоту лесенки. Для каждой строки количество
символов # уменьшается на один.*/
fun getLadder() {
    println("Введите число ступеней")
    val steps: Int = readln().toIntOrNull() ?: 0
    if (steps == 0) println("Вы ввели 0 - ступеней не будет")
    if (steps < 0) steps * (-1)
    for (i in steps downTo 1){
        println("\t".repeat(i) + "#")
    }
}

fun progInterface(){
    println("""
        Введите 1 чтобы проверить задание 1
        Введите 2 чтобы проверить задание 2
        Введите 3 чтобы проверить задание 3
        Введите 4 чтобы проверить задание 4
    """.trimIndent())
    val firstSelection: String = readln()
    when (firstSelection){
        "1" -> polydromeCheck()
        "2" -> isPrimeNumber()
        "3" -> digitsSum()
        "4" -> getLadder()
        else -> println("Не корректный ввод")
    }
    println("Проверить следующее задание - 1")
    println("Завершить программу - 2")
    val secondSelection: String = readln()
    if (secondSelection == "2") {
        println("Всего доброго!")
        Thread.sleep(3000)
        exitProcess(0)
    }
    else if (secondSelection == "1")progInterface()
    else {
        println("Ошибка ввода!")
        Thread.sleep(3000)
        exitProcess(1)
    }
}

fun main() {
    progInterface()
}


