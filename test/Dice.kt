fun main() {
    val myFirstDice = Dice()  //parentheses call constructor
    println(myFirstDice.sides)
    myFirstDice.roll()

}

class Dice {
    var sides = 6  //variables are var; final (const) vals are val.
    fun roll() {
        val randomNumber = (1..6).random()
        println(randomNumber)
    }
}
