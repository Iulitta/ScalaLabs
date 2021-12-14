/*
1. Переменные res - это значения val или настоящие переменные var?

Ответ: это значения val.

scala> math.sqrt(4)
val res0: Double = 2.0

scala> res0 = 5
-- Error:
1 |res0 = 5
  |^^^^^^^^
  |Reassignment to val res0

/*
2. Ввести команду "crazy"*3 в REPL
*/
scala> "crazy"*3
val res1: String = crazycrazycrazy

/*
3. Что означает выражение 10 max 2? В каком классе определен метод max?

Ответ: max выбирает наибольшее число из двух. Данный метод определён
в классах Int, Long, Float, Double.
*/
scala> 10 max 2
val res2: Int = 10

scala> 10.max(12)
val res3: Int = 12

/*
4. Используя число типа BigInt, вычислите 2^1024.
*/
scala> BigInt(2) pow (1024)
val res4: BigInt = 179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216

/*
5. Что нужно импортировать, чтобы найти случайное простое число вызовом
метода probablePrime(100, Random) без использования каких-либо префиксов
перед именами probablePrime и Random?

Ответ: надо импортировать метод probablePrime из класса BigInt и класс Random
*/
scala> import scala.util.Random
scala> import scala.math.BigInt.probablePrime

scala> probablePrime(100, Random)
val res5: BigInt = 1204744574226192082971827895883

/*
6. Один из способов создать файл или каталог со случайным именем состоит в
том, чтобы сгенерировать случайное число типа BigInt  и преобразовать
его в систему счисления по основанию 36, в результате получится строка,
такая как "qsnvbevtomcj38o06kul". Найдите в Scaladoc методы, которые можно
было бы использовать для этого.
*/
scala> probablePrime(200, Random).toString(36)
val res6: String = 99fugv6x7agtcza9csys5n4tkts23ut7ie6p7v5

/*
7. Как получить первый символ строки в языке Scala? А последний символ?

Ответ: с помощью переменных head и last
*/
scala> "String".head
val res7: Char = S

scala> "String".last
val res8: Char = g

/*
8. Что делают строковые функции take, drop, takeRight и dropRight? Какие
преимущества и недостатки они имеют в сравнении с substring?

Ответ:
- drop возвращает строку из всех символов, кроме n первых;
- dropRight возвращает строку из всех символов, кроме n последних;
- take возвращает строку из n первых символов;
- takeRight возвращает строку из n последних символов.
*/
scala> var str = "Some String Lmao"
var str: String = Some String Lmao

scala> str.drop(5)
val res9: String = String Lmao

scala> str.take(11)
val res10: String = Some String

scala> str.dropRight(11)
val res12: String = "Some "

scala> str.takeRight(4)
val res13: String = Lmao

/*
9. Сигнум числа равен 1, если число положительное. -1 - если отрицательное,
и 0 - если равно нулю. Напишите функцию, вычисляющую это значение.
*/
scala> def signum(num: Int): Int = if (num > 0) 1 else if (num < 0) -1 else 0
def signum(num: Int): Int

scala> signum(1901)
val res14: Int = 1

scala> signum(-1901)
val res15: Int = -1

scala> signum(0)
val res16: Int = 0

/*
10. Какое значение возвращает блок {}? Каков его тип?

Ответ: блок {} не возвращает значение, и его тип Unit.
*/
scala> var empty = {}
var empty: Unit = ()

scala> println(empty)
()

/*
11. Напишите  на  языке Scala цикл,  эквивалентный  циклу  на  языке Java
for (int i = 10; i >= 0; i--) System.out.println(i);
*/
scala> for(i <- 10 to 0 by -1) println(i)
10
9
8
7
6
5
4
3
2
1
0

/*
12. Напишите процедуру countdown(n: Int), которая выводит числа от n до 0.
*/
scala> def countdown(n: Int) = for(i <- n to 0 by -1) println(i)
def countdown(n: Int): Unit

scala> countdown(5)
5
4
3
2
1
0

scala> countdown(3)
3
2
1
0

/*
13. Напишите цикл  for  для  вычисления  кодовых пунктов Юникода всех букв в
строке. Например, произведение символов в строке «Hello» равно 9415087488L.
*/
scala> (for(i <- "Hello") yield i.toLong).product
val res17: Long = 9415087488

/*
14. Решите предыдущее упражнение без применения цикла. Напишите  функцию
product(s: String), вычисляющую произведение, как описано в предыдущих
упражнениях.
*/
scala> str.map(c => c.toLong).product
val res18: Long = 9415087488
*/