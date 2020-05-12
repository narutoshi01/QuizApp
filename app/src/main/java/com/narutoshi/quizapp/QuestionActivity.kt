package com.narutoshi.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val questionsList = Questions.getQuestions()
        println(questionsList[0].id)
    }
}
