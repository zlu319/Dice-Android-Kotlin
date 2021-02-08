/*
@Author Zhou Lu
 */
package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        //R.id.button is the resource ID for the Button, which is a unique identifier for it.
        // Android automatically assigns ID numbers to the resources in your app.
        // Resource IDs are of the form R.<type>.<name>; for example, R.string.roll.
        // For View IDs, the <type> is id, for example, R.id.button
        rollButton.setOnClickListener({
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
        })
    }
}