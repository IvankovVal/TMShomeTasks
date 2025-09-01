import java.util.Scanner









//Вывести таблицу умножения
fun main() {
    for (i in 1..9){
        for (j in 1..9){
            if (j*i<=9) print("${i*j}____")
            else print("${i*j}___")
        }
        println()
    }
}
