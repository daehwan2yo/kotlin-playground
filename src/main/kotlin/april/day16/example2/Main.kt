package april.day16.example2

fun max(a: Int, b: Int) = if (a > b) a else b

fun equal(a: Int, b: Int): Boolean {
    val check = true
    return (a==b)
    if (a == b) return check else return !check
}

fun main() {
    val a = 3
    val b = 5

    println(max(a,b))
    println(equal(a,b))
}