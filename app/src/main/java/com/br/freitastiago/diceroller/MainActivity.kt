package com.br.freitastiago.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /** A linha abaixo importa o Button de um dos nossos layouts **/
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            /** A linha abaixo importa o TextView de um dos nossos layouts **/
            val resultTextView: TextView = findViewById(R.id.textView)
            val dice = Dice(6)
            val diceRoll = dice.roll()
            /** A linha abaixo altera propriedades da TextView que importamos para a
             * variavel resultTextView **/
            resultTextView.text = diceRoll.toString()

        }

    }

}
/** A linha abaixo Randomiza um numero **/
class Dice(private val numSides: Int) {
    fun roll(): Int { return (1..numSides).random() }
}