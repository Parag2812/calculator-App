package com.example.mygfgl3app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var plusButton = findViewById<Button>(R.id.btnPlus)
        var minusButton = findViewById<Button>(R.id.btnMinus)
        var Counter = findViewById<TextView>(R.id.counter)
        var Reset = findViewById<TextView>(R.id.reset)

        plusButton.setOnClickListener {
            var value = Integer.parseInt(Counter.text.toString())
                value++
            Counter.text = value.toString()
        }

        minusButton.setOnClickListener {
            var value =  Integer.parseInt(Counter.text.toString())
            value --
            Counter.text = value.toString()
        }

        Reset.setOnClickListener {
            Counter.text = "0"

        }

    }
}