package com.example.sharedpreferencesdemo

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var greetingTextView: TextView
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var cityEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var loadButton: Button
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState) // Call this first
        setContentView(R.layout.activity_main)

        greetingTextView = findViewById(R.id.tv_greeting)
        nameEditText = findViewById(R.id.et_name)
        ageEditText = findViewById(R.id.et_age)
        cityEditText = findViewById(R.id.et_city)
        saveButton = findViewById(R.id.btn_save)
        loadButton = findViewById(R.id.btn_load)
        clearButton = findViewById(R.id.btn_clear)

        //set up button click listeners
        saveButton.setOnClickListener {
            saveData()
        }

        loadButton.setOnClickListener {
            loadData()
        }

        clearButton.setOnClickListener {
            clearData()
        }
    }

    private fun validateInputs(): Boolean {
        // Check if any field is empty
        if (nameEditText.text.isBlank() || ageEditText.text.isBlank() || cityEditText.text.isBlank()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val name = nameEditText.text.toString()
        val age = ageEditText.text.toString()
        val city = cityEditText.text.toString()

        // Save data
        editor.putString("userName", name)
        editor.putString("userAge", age)
        editor.putString("userCity", city)
        editor.apply()

        greetingTextView.text = "Data saved!"
        Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("userName", "No name saved")
        val age = sharedPreferences.getString("userAge", "No age saved")
        val city = sharedPreferences.getString("userCity", "No city saved")

        greetingTextView.text = "Hye, My name is $name! I am $age years old and I live in $city."
    }

    private fun clearData() {
        val sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear() // Clears all data
        editor.apply()

        greetingTextView.text = "Data cleared!"
        Toast.makeText(this, "Data cleared successfully", Toast.LENGTH_SHORT).show()
    }
}