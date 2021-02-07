fun main() {
    val diceRange: IntRange= 1..6
    println(diceRange)
    val randomNumber = diceRange.random()
    println("Random number: ${randomNumber}")

}
