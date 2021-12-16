package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    /**
     * Roll dice executes updating the image to represent the current rolled number
     */
    private fun rollDice() {
        /* Dice obj created from Dice class */
        val dice = Dice(6)
        val dice2 = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()

        /* Find ImageView in the layout */
        val diceImage: ImageView = findViewById(R.id.diceView)
        val diceImage2: ImageView = findViewById(R.id.diceView2)

        /* When statement checks the diceRoll based on the roll */
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Updates the image to display the correct drawable based on the roll
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll.toString()
    }
}
/**
 * Class blueprint for Dice
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}