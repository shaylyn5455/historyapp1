package com.shaylyn.myhistoryapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    //declare
    private lateinit var searchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var editText: EditText
    private lateinit var clearButton: Button

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //initialise
        searchButton = findViewById(R.id.searchButton)
        clearButton = findViewById(R.id.clearButton)
        resultTextView = findViewById(R.id.resultTextView)
        editText = findViewById(R.id.editText)

        searchButton.setOnClickListener {
            Log.d("MainActivity", "click on search button")
            //create variable of age to ger name from user
            val age = editText.text.toString().toIntOrNull()
            Log.d("<ainActivity", "age has been entered: $age")

            //if name is not null and age is in the range between
            if (age != null && age in 20..100) {
                Log.d("MainActivity", "age is valid")

                //when age 55 display King Henry The Eight else when is .. and so on
                val historicalFigure = when (age) {
                    55 -> "King Henry The Eight."
                    57 -> "Thomas More  was a humanist scholar and Lord Chancellor of England, who refused to accept Henry as Supreme Head of the Church and was executed for treason in 1535." +
                            "        Born   7 February 1478 died 6 July 1535"
                    35 -> "Anne Boleyn" +
                            "She was the second wife of Henry and the mother of Elizabeth I, who was a champion of the Protestant cause and influenced Henry to break with Rome. She was accused of adultery, …" +
                            "Born 1501 died 1536"
                    46 -> "William Tyndale" +
                            "He was a scholar and translator, who was the first to produce an English version of the New Testament from the original Greek." +
                            "Born 1490 died 1536"
                    25 -> "Anne Askew" +
                            "She was a poet and Protestant martyr, who was arrested for heresy and tortured in the Tower of London" +
                            "Born 1521 died 1546 "
                    70 -> "Elizabeth I was the only surviving child of Henry VIII and Anne Boleyn" +
                            "Born 1533 died 1603"
                    96 -> "Sir Walter Raleigh was an English statesman, soldier, writer and explorer. One of the most notable figures of the Elizabethan era, he played a leading part in English colonisation of North America." +
                            "Born 1552 died  1618"
                    58 -> "Charles v" +
                            "was Holy Roman Emperor and Archduke of Austria from 1519 to 1556, King of Spain from 1516 to 1556, and Lord of the Netherlands as titular Duke of Burgundy from 1506 to 1555"
                    68 ->"Edward I of England  I, also known as Edward Longshanks and the Hammer of the Scots, was King of England from 1272 to 1307"
                    36 -> "Catherine Parr (she signed her letters as Kateryn; 1512 – 5 September 1548[2][4]) was Queen of England and Ireland as the last of the six wives of King Henry VIII from their marriage on 12 July 1543 until Henry's death on 28 January 1547."
                    else -> null
                }

                val message =
                    if (historicalFigure != null) "the historical figures name $historicalFigure."
                    else "no historical figure with entered age "
                resultTextView.text = message
            } else {
                Log.d("MainActivity", "Invalid age or format")
                resultTextView.text =
                    "invalid age or format. Please enter a whole number between the age of 20 and 100"
            }
        }

        clearButton.setOnClickListener {
            editText.text.clear()
            resultTextView.text = ""
        }
    }
}

