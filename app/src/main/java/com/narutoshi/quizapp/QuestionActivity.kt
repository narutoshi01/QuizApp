package com.narutoshi.quizapp

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var questionsList: ArrayList<Question>? = null
    private var currentQuestionId: Int = 1
    private var selectedOption: Int = 0
    private var correctAnswersNum: Int = 0

    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        userName = intent.getStringExtra(IntentKey.USER_NAME.name)


        questionsList = Questions.getQuestions()

        setQuestion()

        txtViewOption1.setOnClickListener(this)
        txtViewOption2.setOnClickListener(this)
        txtViewOption3.setOnClickListener(this)
        txtViewOption4.setOnClickListener(this)
        bottomBtn.setOnClickListener(this)

    }

    private fun setQuestion() {
//        currentQuestionId = 1
        selectedOption = 0
        val currentQuestion = questionsList!![currentQuestionId - 1]

        setOptionsToDefault()

        if (currentQuestionId == questionsList!!.size) {
            bottomBtn.setText(R.string.finish)
        } else {
            bottomBtn.setText(R.string.submit)
        }

        txtViewQuestionText.text = currentQuestion.question
        imgViewFlag.setBackgroundResource(currentQuestion.image)
        progressBar.max = questionsList!!.size
        progressBar.progress = currentQuestionId
        txtViewProgress.text = "$currentQuestionId/${questionsList!!.size}"
        txtViewOption1.text = currentQuestion.option1
        txtViewOption2.text = currentQuestion.option2
        txtViewOption3.text = currentQuestion.option3
        txtViewOption4.text = currentQuestion.option4
    }

    private fun setOptionsToDefault() {
        val options = ArrayList<TextView>()
        options.add(0, txtViewOption1)
        options.add(1, txtViewOption2)
        options.add(2, txtViewOption3)
        options.add(3, txtViewOption4)

        for (item in options) {
//          item.background = resources.getDrawable(R.drawable.default_option_text_back)
            item.background = ContextCompat.getDrawable(this, R.drawable.default_option_text_back)
            item.typeface = Typeface.DEFAULT // BOLDなどもある
//          item.setTextColor(Color.parseColor("#ffffff")) こんな感じでテキストカラーも設定できたりする
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.txtViewOption1 -> setSelectedOptionView(txtViewOption1, 1)
            R.id.txtViewOption2 -> setSelectedOptionView(txtViewOption2, 2)
            R.id.txtViewOption3 -> setSelectedOptionView(txtViewOption3, 3)
            R.id.txtViewOption4 -> setSelectedOptionView(txtViewOption4, 4)
            R.id.bottomBtn -> {
                when (bottomBtn.text) {
                    getString(R.string.submit) -> {
                        if (selectedOption == 0) {
                            // どの選択肢も選択せずに，次の問題にいく (or フィニッシュ)
                            if (currentQuestionId < questionsList!!.size) {
                                currentQuestionId++
                                setQuestion()
                            }
//                            else {
//                            }
                        } else {
                            val currentQuestion = questionsList!![currentQuestionId - 1]
                            val correctAnswer = currentQuestion.correctAnswer
                            setAnswerView(correctAnswer, R.drawable.correct_option_text_back)
                            if (correctAnswer != selectedOption) {
                                // 間違い
                                setAnswerView(selectedOption, R.drawable.wrong_option_text_back)
                            } else {
                                // 正解
                                correctAnswersNum++
                            }
                            if (currentQuestionId == questionsList!!.size) {
                                bottomBtn.setText(R.string.finish)
                            } else {
                                bottomBtn.setText(R.string.next_question)
                            }
                        }
                    }

                    getString(R.string.next_question) -> {
                        currentQuestionId++
                        setQuestion()
                        bottomBtn.setText(R.string.submit)
                    }

                    getString(R.string.finish) -> {
                        val intent = Intent(this, ResultActivity::class.java).apply {
                            putExtra(IntentKey.USER_NAME.name, userName)
                            putExtra(IntentKey.TOTAL_QUESTIONS.name, questionsList!!.size)
                            putExtra(IntentKey.CORRECT_ANSWERS.name, correctAnswersNum)
                        }
                        startActivity(intent)
                        finish()
                    }
                }

            }
        }
    }

    private fun setAnswerView(answer: Int, drawableResId: Int) {
        when (answer) {
            1 -> txtViewOption1.background = ContextCompat.getDrawable(this, drawableResId)
            2 -> txtViewOption2.background = ContextCompat.getDrawable(this, drawableResId)
            3 -> txtViewOption3.background = ContextCompat.getDrawable(this, drawableResId)
            4 -> txtViewOption4.background = ContextCompat.getDrawable(this, drawableResId)
        }
    }

    private fun setSelectedOptionView(selectedOption: TextView, selectedOptionNum: Int) {
        setOptionsToDefault()

        this.selectedOption = selectedOptionNum
        Log.d("selectedOptionNum", "$selectedOptionNum")


        selectedOption.background =
            ContextCompat.getDrawable(this, R.drawable.selected_option_text_back)
        selectedOption.typeface = Typeface.DEFAULT_BOLD
    }
}
