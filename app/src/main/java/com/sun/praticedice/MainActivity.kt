package com.sun.praticedice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.button_roll)
        onRoll()
        button1.setOnClickListener { onRoll() }
    }
    private fun onRoll() {
        val myDice1 = Dice(6)
        val myDice2 = Dice(6)

        val diceImage1: ImageView = findViewById(R.id.diceImage1)
        val diceImage2: ImageView = findViewById(R.id.diceImage2)

        diceImage1.setImageResource(setContent(myDice1.roll()))
        diceImage2.setImageResource(setContent(myDice2.roll()))
    }
    private fun setContent(nbr: Int): Int {
        return when (nbr) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
class Dice(private val faces: Int) { fun roll(): Int = (1..faces).random() }