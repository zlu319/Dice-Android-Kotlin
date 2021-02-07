/*
@Author michael-land (zhou lu)
Implementation of the following guide
https://developer.android.com/codelabs/basic-android-kotlin-training-create-dice-roller-in-kotlin#5

*/


fun main() {
    val myFirstDice = Dice(6)
    println("Your ${myFirstDice.numSides}-sided dice rolled ${myFirstDice.roll()}.")

    val mySecondDice = Dice(20)
    println("Your ${mySecondDice.numSides}-sided dice rolled ${mySecondDice.roll()}.")
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
