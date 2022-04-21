package april.day21

import april.day20.Color
import april.day20.Color.*
import java.lang.IllegalArgumentException

fun main() {
    println("${mixOptimized(YELLOW, RED)}")
    println("${eval(Sum(Sum(Num(1), Num(2)), Num(4)))}")

    for(i in 1 .. 30) {
        print("${fizzBuzz(i)} ")
    }

    println()
    for(i in 1..30 step 3) {
        print("${fizzBuzz(i)} ")
    }

    println()

    for(i in 100 downTo 1 step 7) {
        print("${fizzBuzz(i)} ")
    }
}

fun fizzBuzz(i : Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 5 == 0 -> "Buzz"
    i % 3 == 0 -> "Fizz"
    else -> "$i"
}

fun eval(e: Expr): Int {
    if(e is Num) {
        return e.value
    }
    if(e is Sum) {
        return eval(e.left) + eval(e.right)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun evalAsIf(e : Expr) : Int =
    if(e is Num) {
        e.value
    }
    else if (e is Sum) {
        evalAsIf(e.left) + evalAsIf(e.right)
    }
    else {
        throw IllegalArgumentException("Unknown Expression")
    }

fun evalAsWhen(e : Expr) : Int =
    when (e) {
        is Num -> e.value
        is Sum -> evalAsWhen(e.left) + evalAsWhen(e.right)
        else -> throw IllegalArgumentException("Unknown Expression")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED)
        -> ORANGE
        else
        -> BLUE
    }

interface Expr
class Num(val value:Int) : Expr
class Sum(val left:Expr, val right:Expr) : Expr