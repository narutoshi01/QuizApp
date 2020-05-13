package com.narutoshi.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(IntentKey.USER_NAME.name)
        val totalQuestions = intent.getIntExtra(IntentKey.TOTAL_QUESTIONS.name, 0)
        val correctAnswers = intent.getIntExtra(IntentKey.CORRECT_ANSWERS.name, 0)

        txtViewUserName.text = userName
        txtViewScore.text = "Your score is $correctAnswers out of $totalQuestions"

        btnFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
