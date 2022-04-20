package april.day20

import april.day20.Color.*

fun main() {

    println("${BLUE.rgb()}")            // 256
    println("${getMnemonic(GREEN)}")    // ...
    println("${getWarmth(RED)}")        // warm
    println("${mix(RED, BLUE)}")        // exception
}

fun mix(c1 : Color, c2:Color) =
    when(setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        else -> throw Exception("Dirty Color")
    }

fun getWarmth(color: Color) =
    when(color) {
        RED, ORANGE, YELLOW -> "warm"
        GREEN -> "neutral"
        else -> "cold"
    }

fun getMnemonic(color: Color) =
    when (color) {
        RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        else -> "..."
    }

class Rectangle(private val height: Int, private val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0), BLUE(0, 0, 255);

    fun rgb() = (r * 256 + g) * 256 + b;
}