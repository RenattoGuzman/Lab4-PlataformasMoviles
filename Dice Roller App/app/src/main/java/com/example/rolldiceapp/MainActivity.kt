package com.example.rolldiceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

    }

    /**
     * Roll the dice and update the screen with the result.
     * Tira el dado y actualiza la pantalla con el resultado.
     */
    private fun rollDice() {
        // Crea un nuevo dado
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Encuentra el Imageview
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determina la imagen que le asignará según el resultado.
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Actualiza la imagen segun lo determinado previamente.
        diceImage.setImageResource(drawableResource)

        // Actualiza la descripción correcta.
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}