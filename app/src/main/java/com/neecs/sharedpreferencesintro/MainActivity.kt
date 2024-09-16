package com.neecs.sharedpreferencesintro

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var counterTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterTextView = findViewById(R.id.counterTextView)

        val sharedPreferences = getSharedPreferences("com.neecs.sharedpreferencesintro", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        var counter = sharedPreferences.getInt("counter", 0)

        counter++

        editor.putInt("counter", counter)
        editor.apply()

        counterTextView.text = counter.toString()
    }
}