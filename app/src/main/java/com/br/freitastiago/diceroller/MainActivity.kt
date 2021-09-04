package com.br.freitastiago.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.SoundEffectConstants
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.toColor
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    
    var scoreNumber = 0
    var failsNumber = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /** A linha abaixo importa o Button de um dos nossos layouts **/
        val resultImageView: ImageView = findViewById(R.id.iv_dice)


        resultImageView.setOnClickListener {
            /** A linha abaixo importa o TextView de um dos nossos layouts **/
            var score: TextView = findViewById(R.id.tv_score)
            val fails: TextView = findViewById(R.id.tv_fail)
            val nullCheck: TextInputEditText = findViewById(R.id.ti_nullCheck)
            val titleTextView: TextView = findViewById(R.id.tv_guess)
            val luckyNumberTI: TextInputEditText = findViewById(R.id.ti_luckynumber)
            val luckyNumber: String = luckyNumberTI.text.toString()
            val dice = Dice(6)

            if (luckyNumber != nullCheck.text.toString()) {
                val diceRoll = dice.roll()
                /** A linha abaixo altera propriedades da TextView que importamos para a
                 * variavel resultTextView **/
                when (diceRoll) {
                    1 -> resultImageView.setImageResource(R.drawable.dice_1)
                    2 -> resultImageView.setImageResource(R.drawable.dice_2)
                    3 -> resultImageView.setImageResource(R.drawable.dice_3)
                    4 -> resultImageView.setImageResource(R.drawable.dice_4)
                    5 -> resultImageView.setImageResource(R.drawable.dice_5)
                    6 -> resultImageView.setImageResource(R.drawable.dice_6)
                }
                if (diceRoll == luckyNumber.toInt()) {
                    titleTextView.setBackgroundColor(0xFF2fa851.toInt())
                    scoreNumber++
                    score.text = scoreNumber.toString()
                    failsNumber = 0
                    fails.text = failsNumber.toString()
                } else {
                        titleTextView.setBackgroundColor(0xFFeb3d3d.toInt())
                        failsNumber++
                        fails.text = failsNumber.toString()
                        scoreNumber = 0
                    score.text = scoreNumber.toString()
                    }
            } else {
                Toast.makeText(this, "Insert a number before rolling!", Toast.LENGTH_SHORT).show()
            }

        }

    }

}

/** A linha abaixo Randomiza um numero **/
class Dice(private val numSides: Int) {
    fun roll(): Int { return (1..numSides).random() }
}