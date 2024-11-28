package com.example.kotlinelogictest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var btNext: Button;
    lateinit var edCount: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btNext = findViewById(R.id.btNext);
        edCount = findViewById(R.id.edCount);

        btNext.setOnClickListener {

            val intent =
                Intent(this, SecondActivity::class.java).putExtra("data", edCount.text.toString().toInt())
            startActivity(intent)
        }

    }
}