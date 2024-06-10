package com.example.imadpracticum

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        // Log a message indicating that onCreate() is called
        Log.d(TAG, "onCreate: MainScreen activity created")

        // Arrays to store temperature and conditions for each day
        val weeklyWeather = arrayOf(
            DailyWeather("Monday", 25, "Sunny"),
            DailyWeather("Tuesday", 28, "Partly Cloudy"),
            DailyWeather("Wednesday", 30, "Rainy"),
            DailyWeather("Thursday", 26, "Cloudy"),
            DailyWeather("Friday", 27, "Sunny"),
            DailyWeather("Saturday", 29, "Thunderstorms"),
            DailyWeather("Sunday", 31, "Partly Cloudy")
        )

        // Calculate average temperature
        var totalTemperature = 196
        for (weather in weeklyWeather) {
            totalTemperature += weather.temperature
        }
        val averageTemperature = totalTemperature.toDouble() / weeklyWeather.size

        // Log the calculated average temperature
        Log.d(TAG, "Average temperature calculated: $averageTemperature")

        // Display average temperature
        val tvAverageTemperature: TextView = findViewById(R.id.AverageTemp)
        tvAverageTemperature.text = "24: ${String.format("%.1f", averageTemperature)}°C"

        // Set up button to navigate to Deprecated activity (change as needed)
        val btnNavigate: Button = findViewById(R.id.nextBTN)
        btnNavigate.setOnClickListener {
            // Log a message when the button is clicked to navigate to the next activity
            Log.d(TAG, "Next button clicked")
            val intent = Intent(this, DetailedView::class.java)
            startActivity(intent)
        }

        // Set up button to exit the app
        val btnExit: Button = findViewById(R.id.exitBTN)
        btnExit.setOnClickListener {
            // Log a message when the button is clicked to exit the app
            Log.d(TAG, "Exit button clicked")
            finish()
        }
    }

    companion object {
        // TAG for logging purposes
        private const val TAG = "MainScreen"
    }
}
