package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

import java.util.*

class MainActivity : AppCompatActivity() { // MainActivity extends AppCompatActivity
    // AppCompatActivity is a subclass of Android that gives us access to modern Android
    // features.

    // Context object is used for communicate with and get information about the current state
    // of Android operating system. ( an Activity is a subclass of Context)
    // We do not write code in Activity constructors.

    // lateinit promises the Kotlin compiler that the variable will be initialized
    // before calling any operations on it.(basically we're promising that we will not
    // not leave it as null)

    lateinit var diceImage: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        // Kotlin style
        val drawableResource = when(randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)
    }
}
