package com.example.mygfgl3app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import net.objecthunter.exp4j.ExpressionBuilder
import java.math.BigDecimal

class CalculatorActivity : AppCompatActivity() {

    lateinit var one :TextView
    lateinit var two :TextView
    lateinit var three :TextView
    lateinit var four :TextView
    lateinit var five :TextView
    lateinit var six :TextView
    lateinit var seven :TextView
    lateinit var eight :TextView
    lateinit var nine :TextView
    lateinit var zero :TextView
    lateinit var doubleZero :TextView

    lateinit var decimal :TextView
    lateinit var equalTo :TextView
    lateinit var divide :TextView
    lateinit var multiply :TextView
    lateinit var minus :TextView
    lateinit var plus :TextView
    lateinit var backSpace : ImageView
    lateinit var modulo :TextView
    lateinit var ac :TextView
    lateinit var result :TextView
    lateinit var expression :TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.sevenForThala)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        doubleZero = findViewById(R.id.doubleZero)

        decimal = findViewById(R.id.decimal)
        equalTo = findViewById(R.id.equalTo)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        minus = findViewById(R.id.minus)
        plus = findViewById(R.id.plus)
        backSpace = findViewById(R.id.backSpace)
        modulo = findViewById(R.id.modulo)
        ac = findViewById(R.id.ac)
        result = findViewById(R.id.result)
        expression = findViewById(R.id.expression)

        var aboutTextview = findViewById<ImageView>(R.id.aboutTextview)

        aboutTextview.setOnClickListener {
            Toast.makeText(this, "Developed by PG Studio" ,Toast.LENGTH_SHORT).show()
        }

        one.setOnClickListener {
            appendText("1", true)
        }

        two.setOnClickListener {
            appendText("2", true)
        }
        three.setOnClickListener {
            appendText("3", true)
        }

        four.setOnClickListener {
            appendText("4", true)
        }
        five.setOnClickListener {
            appendText("5", true)
        }

        six.setOnClickListener {
            appendText("6", true)
        }
        seven.setOnClickListener {
            appendText("7", true)
        }
        eight.setOnClickListener {
            appendText("8", true)
        }
        nine.setOnClickListener {
            appendText("9", true)
        }
        zero.setOnClickListener {
            appendText("0", true)
        }
        doubleZero.setOnClickListener {
            appendText("00", true)
        }
        decimal.setOnClickListener {
            appendText(".", true)
        }





        plus.setOnClickListener {
            appendText("+", false)
        }

        minus.setOnClickListener {
            appendText("-", false)
        }


        divide.setOnClickListener {
            appendText("/", false)
        }

        multiply.setOnClickListener {
            appendText("*", false)
        }

        modulo.setOnClickListener {
            appendText("%", false)
        }





        backSpace.setOnClickListener {
            result.text= ""
            result.hint = ""

            val value = expression.text
            if (value.isNotEmpty()){
                expression.text = value.substring(0,value.length-1)
            }
        }

        ac.setOnClickListener {
            expression.text = ""
            result.text = ""
            result.hint = ""
        }


        equalTo.setOnClickListener {                //  equalTo
             try {
                    val expr = ExpressionBuilder(expression.text.toString()).build()   // from library
                    val answer = expr.evaluate()                                      // from library
                 result.setTextColor(ContextCompat.getColor(this, R.color.white))  // Reset to default color
                    result.text = answer.toString()
             } catch (e: Exception){
                 result.setTextColor(ContextCompat.getColor(this, R.color.red))  // Set error color
                 result.text = e.message                    //error -> like 1/0
            }

        }




    }

    fun appendText(value :String , toBeCleared : Boolean){
        if (result.text != ""){   // if user put 56 and result ="" and then it press other num then clear that expression
            expression.text = ""
        }

        if(toBeCleared){ //value is a number and not a operater  -> clear the result and -> append the value in expression
            result.text =""
            expression.append(value)
        }else{          // else its a operater
            expression.append(result.text)  //56+4=60 and then it press + so 60 + (result put into expreesion)
            expression.append(value)
            result.text = ""
        }
            result.hint = expression.text


    }

}