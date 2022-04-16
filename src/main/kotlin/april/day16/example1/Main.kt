package april.day16.example1

data class Person(val name : String, val age : Int ?= null)

fun main() {
    val persons = listOf(Person("대환", 26), Person("지원", 25))

    val oldest = persons.maxByOrNull { it.age ?: 0 }
    println("나이가 가장 많은 사람은 $oldest")
}