package com.br.freitastiago.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.toColor
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /** A linha abaixo importa o Button de um dos nossos layouts **/
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            /** A linha abaixo importa o TextView de um dos nossos layouts **/
            val titleTextView: TextView = findViewById(R.id.tv_guess)
            val luckyNumberTI: TextInputEditText = findViewById(R.id.ti_luckynumber)
            val luckyNumber: String = luckyNumberTI.text.toString()
            val resultTextView: TextView = findViewById(R.id.textView)
            val dice = Dice(6)
            val diceRoll = dice.roll()
            /** A linha abaixo altera propriedades da TextView que importamos para a
             * variavel resultTextView **/
            resultTextView.text = diceRoll.toString()
            if (diceRoll == luckyNumber.toInt()) {
                Toast.makeText(this, "You got the right number!", Toast.LENGTH_SHORT).show()
                titleTextView.setBackgroundColor(0xFF2fa851.toInt())
            }
            else {
                Toast.makeText(this, "You missed your bet.", Toast.LENGTH_SHORT).show()
                titleTextView.setBackgroundColor(0xFFeb3d3d.toInt())
            }
        }

    }

}
/** A linha abaixo Randomiza um numero **/
class Dice(private val numSides: Int) {
    fun roll(): Int { return (1..numSides).random() }
}