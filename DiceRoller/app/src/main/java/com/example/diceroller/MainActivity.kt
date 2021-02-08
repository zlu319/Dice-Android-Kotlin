/*
@Author Zhou Lu
 */
package com.example.diceroller

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth


const val RC_SIGN_IN = 123


/**
 * This activity lets the user roll a dice and display the result on the screen
 */
class MainActivity : AppCompatActivity() {
    //private lateinit var auth: FirebaseAuth
    private var isLoggedIn: Boolean = false
    private var diceRolls: ArrayList<Int> = ArrayList<Int>()

    //only runs once!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        //R.id.button is the resource ID for the Button, which is a unique identifier for it.
        // Android automatically assigns ID numbers to the resources in your app.
        // Resource IDs are of the form R.<type>.<name>; for example, R.string.roll.
        // For View IDs, the <type> is id, for example, R.id.button
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            rollDice()
        }

        val authProviders = arrayListOf(
                AuthUI.IdpConfig.EmailBuilder().build()
        )

        val loginButton: Button = findViewById(R.id.login_button)

        loginButton.setText(R.string.login_to_save_history)

        loginButton.setOnClickListener {
            if (!isLoggedIn){
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(authProviders)
                                .build(),
                        RC_SIGN_IN
                )
            } else {
                loginButton.setText(R.string.login_to_save_history)
                isLoggedIn = false
            }
        }
    }

    //is called when the firebase auth ui (which is another activity) gives the result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                println("Logged in as ${user}")
                // ...
                isLoggedIn = true
                //do not put this into onCreate; this needs to run all the time
                val loginButton: Button = findViewById(R.id.login_button)
                loginButton.setText(R.string.logout)

                val clearButton: Button = findViewById(R.id.clear_button)
                clearButton.setOnClickListener {
                    diceRolls = ArrayList<Int>()
                    val resultTextView: TextView = findViewById(R.id.textView)
                    resultTextView.text = ""
                }
                if (isLoggedIn)
                {
                    clearButton.setVisibility(View.VISIBLE); //SHOW the button
                }
                //startActivity(Intent(this, MainActivity::class.java))
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
                println("Log in failed")
            }
        }
    }

    /**
     * Roll the Dice and Update the screen with the result
     */
    private fun rollDice() {
        //create a new 6-sided dice
        val dice = Dice(6)
        val diceRoll = dice.roll()
        diceRolls.add(diceRoll)
        //Update the screen with the text of the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        if (!isLoggedIn) {
            resultTextView.text = diceRoll.toString()
        } else {
            resultTextView.text = listRollsToString()
        }

        val diceImage: ImageView = findViewById(R.id.imageView)
        /*
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        */
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
        updateDB()
    }

    //updates the Firebase Real-Time Database
    private fun updateDB() {

    }

    private fun listRollsToString(): String {
        var ret: String = ""
        for (i in diceRolls.indices) {
            ret += diceRolls[i].toString() + " "
        }
        return ret
    }

}

/**
 * This class represents a dice
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}