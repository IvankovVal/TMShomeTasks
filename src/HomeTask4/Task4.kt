package HomeTask4

/*Задание 1: Поиск максимального и минимального элемента массива
Напишите программу, которая находит и выводит максимальное и
минимальное значение в массиве целых чисел. Также вычислите индекс
этих элементов.*/
fun getMaxAndMin(arr: Array<Int>){
    var maxMember:Int = arr[0]
    var maxMemInd:Int = 0
    for (i in 0..arr.size-1){
        if (arr[i]>maxMember){
            maxMember = arr[i]
            maxMemInd = i
        }
    }
    var minMember:Int = arr[0]
    var minMemInd:Int = 0
    for (i in 0..arr.size-1){
        if (arr[i]<minMember){
            minMember = arr[i]
            minMemInd = i
        }
    }
    println("""
        $maxMember - наибольший элемент массива с индексом $maxMemInd
        $minMember - наибольший элемент массива с индексом $minMemInd
    """.trimIndent())
}

/*Задание 2: Подсчет четных и нечетных чисел в массиве
Напишите программу, которая принимает массив целых чисел
и подсчитывает, сколько четных и сколько нечетных чисел в
нем содержится.*/
fun evenNotEvenCounter(arr: Array<Int>){
    var evenCount:Int = 0
    var notEvenCount:Int = 0
    arr.forEach {
        if (it % 2 == 0) evenCount = evenCount + 1
        else notEvenCount = notEvenCount + 1
    }
    println("""
        В данном массиве
            чётных - $evenCount
            не чётных - $notEvenCount
    """.trimIndent())
}

/*Задание 3: Реверс массива
Напишите программу, которая принимает массив целых чисел и изменяет
его порядок на обратный. Выведите результат после изменения порядка.*/
fun reversArray(arr: Array<Int>){
    val reversArr: Array<Int> = Array(arr.size, { i -> 0})
    for (i in arr.indices){
        reversArr[i] = arr[arr.size - 1 - i]
        print("${reversArr[i]} ")
    }
}

/*Напишите программу, которая проверяет, является ли массив чисел
палиндромом.
* Массив считается палиндромом, если он одинаково читается
как слева направо, так и справа налево.*/
fun isPolyandrousOrNot(arr: Array<Int>){
    if (arr.size % 2 == 0){
        //Чётное количество элементов
        val arr1: Array<Int> = Array(arr.size/2,{i -> 0})
        val arr2: Array<Int> = Array(arr.size/2,{i -> 0})
        for (i in arr.indices){
            when(i){
                in 0..arr.size/2-1 -> arr1[i] = arr[i]
                in arr.size/2..arr.size-1 -> arr2[i - arr.size/2] = arr[i]
            }
        }
        var isPolyandrous = true
        for (i in arr1.indices){
            if (arr1[i] != arr2[arr2.size - 1 - i])isPolyandrous = false
        }
        println(
            if (isPolyandrous)"Массив является полиднромом"  else "Массив не является полиндромом"
        )
    }
    else{
        //Не чётное количество элементов
        val arr1: Array<Int> = Array(arr.size/2,{i -> 0})
        val arr2: Array<Int> = Array(arr.size/2,{i -> 0})

        for (i in arr.indices){
            try {
                when(i){
                    in 0..arr.size/2-1 -> arr1[i] = arr[i]
                    in arr.size/2 + 1..arr.size-1 -> arr2[(i - arr.size/2)-1] = arr[i]
                    else -> continue
                }
            }
            catch (e: ArrayIndexOutOfBoundsException){
                println("Плохой индекс - $i")
            }

        }
        var isPolyandrous = true
        for (i in arr1.indices){
            if (arr1[i] != arr2[arr2.size - 1 - i])isPolyandrous = false
        }
        println(
            if (isPolyandrous)"Массив является полиднромом"  else "Массив не является полиндромом"
        )
    }
}



fun main() {
    println("-=Первое задание=-")
    getMaxAndMin(arrayOf(1,2,4,6,5,7,3,12,23,99))
    println("-=Второе задание=-")
    evenNotEvenCounter(arrayOf(1,2,4,6,5,7,3,12,23,99))
    println("-=Третье задание=-")
    reversArray(arrayOf(1,2,4,6,5,7,3,12,23,99))
    println("-=Четвёртое задание=-")
    isPolyandrousOrNot(arrayOf(1,2,4,6,5,7,3,12,23,99))
    isPolyandrousOrNot(arrayOf(1,2,4,4,2,1))
    isPolyandrousOrNot(arrayOf(1,2,4,19,4,2,1))
    isPolyandrousOrNot(arrayOf(1,2,4,56565,4,21,1))

}