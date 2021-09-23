package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
rollDice()
        rollButton.setOnClickListener {
            rollDice()

        }
    }
    private fun rollDice(){
        val dice = Dice(6)
        val diceRoll = dice.Roll()

        val resultImage: ImageView = findViewById(R.id.imageView)
        val image= when(diceRoll){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else ->   R.drawable.dice_6
        }
        resultImage.contentDescription=diceRoll.toString()
        resultImage.setImageResource(image)
    }

}

class Dice(private val numSides: Int){
    fun Roll():Int{
        return (1..numSides).random()
    }
}
