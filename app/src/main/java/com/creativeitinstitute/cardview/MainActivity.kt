package com.creativeitinstitute.cardview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display for the activity
        enableEdgeToEdge()

        // Set the content view to the XML layout
        setContentView(R.layout.activity_main)

        // Ensure the root layout has a proper ID in your XML (e.g., ConstraintLayout or LinearLayout with ID "main")
        val rootView = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.rootLayout)

        // Apply window insets to manage system bars
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // Adjust padding to prevent content from being hidden by system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            // Return the insets to indicate handling is complete
            insets
        }
    }
}