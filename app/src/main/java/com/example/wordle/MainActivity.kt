package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var counter = 0
    var wordToGuess = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)

        val guess1 = findViewById<TextView>(R.id.Guess1)
        val guess1check = findViewById<TextView>(R.id.Guess1check)
        val guess1result = findViewById<TextView>(R.id.guess1result)
        val guess1hint = findViewById<TextView>(R.id.guess1hint)

        val guess2 = findViewById<TextView>(R.id.Guess2)
        val guess2check = findViewById<TextView>(R.id.Guess2check)
        val guess2result = findViewById<TextView>(R.id.guess2result)
        val guess2hint = findViewById<TextView>(R.id.guess2hint)

        val guess3 = findViewById<TextView>(R.id.Guess3)
        val guess3check = findViewById<TextView>(R.id.Guess3check)
        val guess3result = findViewById<TextView>(R.id.guess3result)
        val guess3hint = findViewById<TextView>(R.id.guess3hint)

        val simpleEditText = findViewById<EditText>(R.id.et_simple)

        val target = findViewById<TextView>(R.id.textView7)
        target.text = wordToGuess


        button.setOnClickListener {
            if (counter == 2) {
                guess3result.text = simpleEditText.text
                if(guess3result.text.toString().length != 4){
                    Toast.makeText(it.context, "Input the FOUR letter word", Toast.LENGTH_SHORT).show()
                }else {
                    guess3hint.text = checkGuess(guess3result.text.toString())
                    counter++
                }
            }

            if (counter >= 3) {
                guess3.visibility = View.VISIBLE
                guess3check.visibility = View.VISIBLE
                guess3result.visibility = View.VISIBLE
                guess3hint.visibility = View.VISIBLE
                Toast.makeText(it.context, "Run out of your chances!", Toast.LENGTH_SHORT).show()
                target.visibility = View.VISIBLE
                button.visibility = View.INVISIBLE
                button2.visibility = View.VISIBLE
            }

            if (counter == 1) {
                guess2result.text = simpleEditText.text
                if(guess2result.text.toString().length != 4){
                    Toast.makeText(it.context, "Input the FOUR letter word", Toast.LENGTH_SHORT).show()
                }
                else {
                    guess2hint.text = checkGuess(guess2result.text.toString())
                    counter++
                }
            }

            if (counter >= 2) {
                guess2.visibility = View.VISIBLE
                guess2check.visibility = View.VISIBLE
                guess2result.visibility = View.VISIBLE
                guess2hint.visibility = View.VISIBLE
            }

            if (counter == 0) {
                guess1result.text = simpleEditText.text
                if(guess1result.text.toString().length != 4){
                    Toast.makeText(it.context, "Input the FOUR letter word", Toast.LENGTH_SHORT).show()
                }
                else{
                    guess1hint.text = checkGuess(guess1result.text.toString())
                    counter++
                }
            }

            if (counter >= 1) {
                guess1.visibility = View.VISIBLE
                guess1check.visibility = View.VISIBLE
                guess1result.visibility = View.VISIBLE
                guess1hint.visibility = View.VISIBLE
            }
        }

        button2.setOnClickListener {
            guess1.visibility = View.INVISIBLE
            guess1check.visibility = View.INVISIBLE
            guess1result.visibility = View.INVISIBLE
            guess1hint.visibility = View.INVISIBLE

            guess2.visibility = View.INVISIBLE
            guess2check.visibility = View.INVISIBLE
            guess2result.visibility = View.INVISIBLE
            guess2hint.visibility = View.INVISIBLE

            guess3.visibility = View.INVISIBLE
            guess3check.visibility = View.INVISIBLE
            guess3result.visibility = View.INVISIBLE
            guess3hint.visibility = View.INVISIBLE

            target.visibility = View.INVISIBLE
            button.visibility = View.VISIBLE
            button2.visibility = View.INVISIBLE

            counter = 0
            wordToGuess = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()

        }
    }
    fun checkGuess(guess: String): String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            } else if (guess[i] in wordToGuess) {
                result += "+"
            } else {
                result += "X"
            }
        }
        return result
    }
}