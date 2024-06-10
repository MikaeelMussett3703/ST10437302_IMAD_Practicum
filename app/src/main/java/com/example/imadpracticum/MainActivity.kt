package com.example.imadpracticum

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity" // Logging Main tag

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        Log.d(TAG, "Splash screen created.")

        // Delay showing the navigation dialog by 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            showNavigationDialog()
        }, 3000)
    }

    private fun showNavigationDialog() {
        Log.d(TAG, "Showing navigation dialog.")

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Choose an option")
            .setPositiveButton("Go to Main Screen") { _, _ ->
                Log.d(TAG, "User chose to go to Main Screen.")
                val intent = Intent(this@MainActivity, MainScreen::class.java)
                startActivity(intent)
                finish()
            }
            .setNegativeButton("Exit App") { _, _ ->
                Log.d(TAG, "User chose to exit the app.")
                finishAffinity()
            }
        builder.create().show()
    }
}
