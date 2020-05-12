package com.narutoshi.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val questionsList = Questions.getQuestions()

        var currentQuestionId = 1
        var currentQuestion = questionsList[currentQuestionId - 1]

        txtViewQuestionText.text = currentQuestion.question
        imgViewFlag.setBackgroundResource(currentQuestion.image)
        progressBar.max = questionsList.size
        progressBar.progress = currentQuestionId
        txtViewProgress.text = "$currentQuestionId/${questionsList.size}"
        txtViewOption1.text = currentQuestion.option1
        txtViewOption2.text = currentQuestion.option2
        txtViewOption3.text = currentQuestion.option3
        txtViewOption4.text = currentQuestion.option4

    }
}
