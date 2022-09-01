package com.example.newquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvSvcore: TextView = findViewById(R.id.tv_score)
        val LastButton: Button = findViewById(R.id.LastBut)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTION, 0)
        val correctAnswer = intent.getIntExtra(Constants.CURRENT_QUESTION, 0)
        tvSvcore.text = "Your Score is $correctAnswer out of $totalQuestion"

        LastButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}