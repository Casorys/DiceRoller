package com.br.freitastiago.diceroller


import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    
    var scoreNumber = 0
    var failsNumber = 0

    var numberToBeChecked = 0

    val dice1Keypad = 1
    val dice2Keypad = 2
    val dice3Keypad = 3
    val dice4Keypad = 4
    val dice5Keypad = 5
    val dice6Keypad = 6

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mpF = MediaPlayer.create(this, R.raw.fart)
        val mpB = MediaPlayer.create(this, R.raw.birl)
        /** A linha abaixo importa o Button de um dos nossos layouts **/
        val resultImageView: ImageView = findViewById(R.id.iv_dice)
        val dice1: ImageView = findViewById(R.id.iv_dice1)
        val dice2: ImageView = findViewById(R.id.iv_dice2)
        val dice3: ImageView = findViewById(R.id.iv_dice3)
        val dice4: ImageView = findViewById(R.id.iv_dice4)
        val dice5: ImageView = findViewById(R.id.iv_dice5)
        val dice6: ImageView = findViewById(R.id.iv_dice6)

        dice1.setOnClickListener {
            numberToBeChecked = 1
            dice1.setBackgroundColor(0xFFd3edc0.toInt())
            dice2.setBackgroundColor(Color.TRANSPARENT)
            dice3.setBackgroundColor(Color.TRANSPARENT)
            dice4.setBackgroundColor(Color.TRANSPARENT)
            dice5.setBackgroundColor(Color.TRANSPARENT)
            dice6.setBackgroundColor(Color.TRANSPARENT)
        }

        dice2.setOnClickListener {
            numberToBeChecked = 2
            dice1.setBackgroundColor(Color.TRANSPARENT)
            dice2.setBackgroundColor(0xFFd3edc0.toInt())
            dice3.setBackgroundColor(Color.TRANSPARENT)
            dice4.setBackgroundColor(Color.TRANSPARENT)
            dice5.setBackgroundColor(Color.TRANSPARENT)
            dice6.setBackgroundColor(Color.TRANSPARENT)
        }

        dice3.setOnClickListener {
            numberToBeChecked = 3
            dice1.setBackgroundColor(Color.TRANSPARENT)
            dice2.setBackgroundColor(Color.TRANSPARENT)
            dice3.setBackgroundColor(0xFFd3edc0.toInt())
            dice4.setBackgroundColor(Color.TRANSPARENT)
            dice5.setBackgroundColor(Color.TRANSPARENT)
            dice6.setBackgroundColor(Color.TRANSPARENT)
        }

        dice4.setOnClickListener {
            numberToBeChecked = 4
            dice1.setBackgroundColor(Color.TRANSPARENT)
            dice2.setBackgroundColor(Color.TRANSPARENT)
            dice3.setBackgroundColor(Color.TRANSPARENT)
            dice4.setBackgroundColor(0xFFd3edc0.toInt())
            dice5.setBackgroundColor(Color.TRANSPARENT)
            dice6.setBackgroundColor(Color.TRANSPARENT)
        }

        dice5.setOnClickListener {
            numberToBeChecked = 5
            dice1.setBackgroundColor(Color.TRANSPARENT)
            dice2.setBackgroundColor(Color.TRANSPARENT)
            dice3.setBackgroundColor(Color.TRANSPARENT)
            dice4.setBackgroundColor(Color.TRANSPARENT)
            dice5.setBackgroundColor(0xFFd3edc0.toInt())
            dice6.setBackgroundColor(Color.TRANSPARENT)
        }

        dice6.setOnClickListener {
            numberToBeChecked = 6
            dice1.setBackgroundColor(Color.TRANSPARENT)
            dice2.setBackgroundColor(Color.TRANSPARENT)
            dice3.setBackgroundColor(Color.TRANSPARENT)
            dice4.setBackgroundColor(Color.TRANSPARENT)
            dice5.setBackgroundColor(Color.TRANSPARENT)
            dice6.setBackgroundColor(0xFFd3edc0.toInt())
        }


        resultImageView.setOnClickListener {
            /** A linha abaixo importa o TextView de um dos nossos layouts **/
            var score: TextView = findViewById(R.id.tv_score)
            val fails: TextView = findViewById(R.id.tv_fail)
            val nullCheck: TextInputEditText = findViewById(R.id.ti_nullCheck)
            val titleTextView: TextView = findViewById(R.id.tv_guess)
            // val luckyNumberTI: TextInputEditText = findViewById(R.id.ti_luckynumber)
            // val luckyNumber: String = luckyNumberTI.text.toString()
            val dice = Dice(6)

            if (numberToBeChecked != 0) {
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
                if (diceRoll == numberToBeChecked) {
                    titleTextView.setBackgroundColor(0xFF2fa851.toInt())
                    scoreNumber++
                    score.text = scoreNumber.toString()
                    failsNumber = 0
                    fails.text = failsNumber.toString()
                    mpB.start()
                    numberToBeChecked = 0
                    dice1.setBackgroundColor(Color.TRANSPARENT)
                    dice2.setBackgroundColor(Color.TRANSPARENT)
                    dice3.setBackgroundColor(Color.TRANSPARENT)
                    dice4.setBackgroundColor(Color.TRANSPARENT)
                    dice5.setBackgroundColor(Color.TRANSPARENT)
                    dice6.setBackgroundColor(Color.TRANSPARENT)
                } else {
                        titleTextView.setBackgroundColor(0xFFeb3d3d.toInt())
                        failsNumber++
                        fails.text = failsNumber.toString()
                        scoreNumber = 0
                    score.text = scoreNumber.toString()
                    mpF.start()
                    numberToBeChecked = 0
                    dice1.setBackgroundColor(Color.TRANSPARENT)
                    dice2.setBackgroundColor(Color.TRANSPARENT)
                    dice3.setBackgroundColor(Color.TRANSPARENT)
                    dice4.setBackgroundColor(Color.TRANSPARENT)
                    dice5.setBackgroundColor(Color.TRANSPARENT)
                    dice6.setBackgroundColor(Color.TRANSPARENT)
                    }
            } else {
                Toast.makeText(this, "Select a number before rolling!", Toast.LENGTH_SHORT).show()
            }

        }

    }

}

/** A linha abaixo Randomiza um numero **/
class Dice(private val numSides: Int) {
    fun roll(): Int { return (1..numSides).random() }
}

