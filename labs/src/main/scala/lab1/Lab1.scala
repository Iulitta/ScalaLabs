package lab1 {
    import scala.math.pow
    import scala.util.control.Breaks._
    import scala.io.StdIn.readLine
    import scala.collection.mutable._
    import scala.collection.mutable

    object Lab1 {

        // Task 14
        def product(s: String): Long = {
            s.map(c => c.toLong).product
        }

        // Task 16
        def prod_rec(s: String, p: Long = 1, step: Long = 1): Long = {
            if (!s.isEmpty) return prod_rec(s.tail, s.head.toLong * p, step + 1)
            else {
                if (step == 1) return 0
                else return p
            }
        }

        // Task 17
        def rec_pow(x: Int, n: Int): Double = {
            if (n > 0 && (n % 2 == 0)) pow(rec_pow(x, n / 2), 2)
            else if (n > 0 && (n % 2 == 1)) (x * rec_pow(x, n - 1))
            else if (n == 0) 1
            else 1 / rec_pow(x, -n)
        }

        // Task 18
        def natural_sum(m: Int, n: Int): Int = {
            var sum: Int = 0
            for (i <- m to n) {
                val set = mutable.Set[Int]()
                var num = i
                var flag = true
                breakable {
                    while (num > 0) {
                        val sym = num % 10
                        if (!set.add(sym)) {
                            flag = false
                            break
                        }
                        num = num / 10
                    }
                }
                set.clear()
                if (flag) sum = sum + i
            }
            sum
        }

        // Task 19
        def task19(list: List[Any]): List[Any] = {
            var arr = ArrayBuffer.empty[Any]
            for (i <- list) {
                if (i.isInstanceOf[Int]) arr += i
                else arr ++= task19(i.asInstanceOf[List[Any]])
            }
            arr.toList
        }

        // Task 20
        def task20(n: Int): Int = {
            var sum: Int = 0
            var max: Int = -1
            for (i <- 2 to n / 2) {
                if (n % i == 0) {
                    if (isPrime(i) && i > max) max = i
                }
            }
            println(max)
            while (max > 0) {
                val sym = max % 10
                sum = sum + sym
                max = max / 10
            }
            sum
        }

        // Простое ли число
        def isPrime(n: Int): Boolean = {
            var flag: Boolean = true
            breakable {
                for (i <- n - 1 to 2 by -1) {
                    if (n % i == 0) {
                        flag = false
                        break
                    }
                }
            }
            flag
        }

        // Task 21
        def task21(list: List[Int], k: Int): List[Int] = {
            val set = mutable.Set[Int]()
            for (i <- list) {
                val count = list.count(_ == i)
                if (count == k) set.add(i)
            }
            set.toList.sorted
        }

        // Task 24
        // Наименьшее общее кратное
        def nok(m: Int, n: Int): Int = {
            m / nod(m, n) * n
        }

        // Наименьший общий делитель
        def nod(m: Int, n: Int): Int = {
            if (n > 0) nod(n, m % n)
            else m
        }

        // Task 25
        def task25(list: List[Int], k: Int): List[Int] = {
            var arr = ArrayBuffer.empty[Int]
            for (i <- 0 to list.size - 1) {
                if (((i + 1) % k) != 0) arr += list(i)
            }
            arr.toList
        }

        // Task 26. Размещение без повторений
        def task26(n: Int, k: Int): Int = {
            if (n < k) 0
            else {
                var a_nk = 1
                for (i <- n to (n - k + 1) by -1) a_nk = a_nk * i
                a_nk
            }
        }

        // Task 27
        def task27(list: List[Int], k: Int): List[Int] = {
            val copy = list.toArray
            if (k > 0 || k < 0) {
                for (i <- 0 to list.size - 1) {
                    var ind = i - k
                    if (ind < 0) ind = ind + list.size
                    else if (ind >= list.size) ind = ind % list.size
                    copy(ind) = list(i)
                }
                copy.toList
            }
            else list
        }

        // Task 28
        def task28(n: Long): Long = {
            var num: Long = 0
            val start: Long = 1
            for (i <- start to n) {
                var s: Long = 0
                for (j <- start to i) {
                    if ((i % j == 0) && (j != i))
                        s = s + j;
                }
                if (i == s) num = i
            }
            num
        }

        // Task 29
        def task29(list: List[Int]): Unit = {
            var arr1 = ArrayBuffer.empty[Int]
            var arr2 = ArrayBuffer.empty[Int]
            for (i <- 0 to list.size - 1) {
                if (i % 2 == 0) arr2 += list(i)
                else arr1 += list(i)
            }
            // Вывод результата внутри функции
            println(list)
            println(arr1.toList)
            println(arr2.toList)
        }

        // Task 30
        def task30(n: Int): Int = {
            var max = 1
            for (i <- 1 to n) {
                var sum = 0
                var num = i
                while (num > 0) {
                    sum = sum + (num % 10)
                    num = num / 10
                }
                var power = 2
                var res = 1
                var flag = false
                while (res < i) {
                    res = pow(sum, power).toInt
                    if (res > i) flag = false
                    else if (res == i) flag = true
                    else power = power + 1

                    // Финальная проверка
                    if (sum == 1 || res == 1) {
                        flag = false
                        res = i
                    }
                }
                if (flag && (i > max)) max = i
            }
            max
        }

        // Task 31
        def task31(list: List[(Int, String)]): Unit = {
            var arr1 = ArrayBuffer.empty[Int]
            var arr2 = ArrayBuffer.empty[String]
            for (i <- list) {
                arr1 += i._1
                arr2 += i._2
            }
            // Вывод результата внутри функции
            println(list)
            println(arr1.toList)
            println(arr2.toList)
        }

        // Главная функция для лабы
        def main(args: Array[String]): Unit = {
            var task = 1
            while (task != 0) {
                task = readLine("Номер задания (14-31, 0 - выход): ").toInt
                if (task == 14) println(product("Hello"))
                else if (task == 16) println(prod_rec("Hello"))
                else if (task == 17) {
                    println(rec_pow(5, 2))
                    println(rec_pow(5, 3))
                    println(rec_pow(5, 0))
                    println(rec_pow(2, -2))
                }
                else if (task == 18) {
                    println(natural_sum(0, 100))
                    println(natural_sum(100, 1000))
                }
                else if (task == 19) {
                    println(task19(List(List(1, 1), 2, List(3, List(5, 8)))))
                    // Результат: List(1, 1, 2, 3, 5, 8)
                }
                else if (task == 20) {
                    println(task20(1000))
                    println(task20(1700720))
                }
                else if (task == 21) {
                    val list = List[Int](3, 5, 2, 1, 5, 1, 2, 5, 3, 2)
                    println(task21(list, 2))
                    println(task21(list, 3))
                }
                else if (task == 24) {
                    println(nok(150, 100))
                    println(nok(39, 65))
                }
                else if (task == 25) {
                    val list = List[Int](3, 5, 2, 1, 5, 1, 2, 5, 3, 2)
                    println(task25(list, 2))
                    println(task25(list, 3))
                }
                else if (task == 26) {
                    println(task26(5, 3))
                    println(task26(5, 5))
                }
                else if (task == 27) {
                    val list = List[Int](3, 5, 4, 2, 1, 5)
                    println(task27(list, 2))
                    println(task27(list, -3))
                    println(task27(list, 0))
                }
                else if (task == 28) {
                    println(task28(30))
                    println(task28(500))
                    println(task28(10000))
                }
                else if (task == 29) {
                    val list = List[Int](3, 5, 2, 1, 5, 1, 2, 5, 3, 2)
                    task29(list)
                }
                else if (task == 30) {
                    println(task30(100))
                    println(task30(1000))
                }
                else if (task == 31) {
                    val list = List[(Int, String)]((3, "str1"), (5, "str2"), (4, "str3"), (2, "str4"))
                    task31(list)
                }
                else if (task == 0) println("Пока!")
                else println("Неправильный номер задания!")
            }

        }

    }

}