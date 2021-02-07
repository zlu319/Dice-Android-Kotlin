/*
@Author michael-land (zhou lu)
Implementation of the following guide
https://developer.android.com/codelabs/basic-android-kotlin-training-create-dice-roller-in-kotlin#5

*/


fun main() {
    val myFirstDice = Dice(6)  //parentheses call constructor
    //println(myFirstDice.sides)
    //val diceRoll = myFirstDice.roll()
    println("Your ${myFirstDice.numSides}-sided dice rolled ${myFirstDice.roll()}.")

    //myFirstDice.numSides = 20 error, val cannot be reassigned (note you used val in the Dice class)
    //println("Your ${myFirstDice.numSides}-sided dice rolled ${myFirstDice.roll()}.")

    val mySecondDice = Dice(20)
    println("Your ${mySecondDice.numSides}-sided dice rolled ${mySecondDice.roll()}.")
}

class DiceSix {
    var sides = 6  //variables are var; final (const) vals are val.
    fun roll(): Int {
        val randomNumber = (1..sides).random()
        //println(randomNumber)
        return randomNumber
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        val randomNumber = (1..numSides).random()
        //println(randomNumber)
        return randomNumber
    }
}
