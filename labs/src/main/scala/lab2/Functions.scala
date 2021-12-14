package lab2 {
    // Напишите отдельные функции, решающие поставленную задачу.
    object Functions {
        // a) Напишите функцию, которая рассчитывает площадь окружности: r^2 * Math.PI
        def CircleSquare(r: Double): Double = r * r * Math.PI

        // Примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
        def testCircle(r: Double): Double = CircleSquare(r)

        // b) Напишите каррированную функцию которая рассчитывает площадь прямоугольника a * b
        def RectangleSquare(a: Double)(b: Double): Double = a * b

        // Примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
        def testRectangleCurried(a: Double, b: Double): Double = RectangleSquare(a)(b)

        // c) Напишите не каррированную функцию для расчета площади прямоугольника.
        def RectangleUc(a: Double, b: Double): Double = a * b

        // Примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
        def testRectangleUc(a: Double, b: Double): Double = RectangleUc(a, b)

        // Точка входа в программу
        def main(args: Array[String]): Unit = {
            println("Task a")
            println(testCircle(10))
            println("\nTask b")
            println(testRectangleCurried(2, 5))
            println("\nTask c")
            println(testRectangleUc(5, 4))
        }
    }

}

