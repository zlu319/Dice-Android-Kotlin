fun main() {
    val myFirstDice = Dice()  //parentheses call constructor
    //println(myFirstDice.sides)
    //val diceRoll = myFirstDice.roll()
    println("Your ${myFirstDice.sides}-sided dice rolled ${myFirstDice.roll()}.")

    myFirstDice.sides = 20
    println("Your ${myFirstDice.sides}-sided dice rolled ${myFirstDice.roll()}.")

}

class Dice {
    var sides = 6  //variables are var; final (const) vals are val.
    fun roll(): Int {
        val randomNumber = (1..sides).random()
        //println(randomNumber)
        return randomNumber
    }
}
