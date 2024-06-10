package com.example.imadpracticum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailedView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        class DetailActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_detailed_view)

                val intent = intent
                val maxTemp = intent.getStringExtra("maxTemp")
                val minTemp = intent.getStringExtra("minTemp")
                val weatherCondition = intent.getStringExtra("weatherCondition")

                val textViewMaxTemp = findViewById<TextView>(R.id.textViewMaxTemp)
                val textViewMinTemp = findViewById<TextView>(R.id.textViewMinTemp)
                val textViewWeatherCondition = findViewById<TextView>(R.id.textViewWeatherCondition)

                textViewMaxTemp.text = "Max Temp: $maxTemp"
                textViewMinTemp.text = "Min Temp: $minTemp"
                textViewWeatherCondition.text = "Weather Condition: $weatherCondition"
            }
        }

    }
}