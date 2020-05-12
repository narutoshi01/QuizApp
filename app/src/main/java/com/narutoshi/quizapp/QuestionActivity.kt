package com.narutoshi.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var questionsList : ArrayList<Question>? = null
    private var currentQuestionId = 1
    private var selectedOption = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        questionsList = Questions.getQuestions()

        setQuestion()

        txtViewOption1.setOnClickListener(this)
        txtViewOption2.setOnClickListener(this)
        txtViewOption3.setOnClickListener(this)
        txtViewOption4.setOnClickListener(this)

    }

    private fun setQuestion() {
        currentQuestionId = 1
        val currentQuestion = questionsList!![currentQuestionId - 1]

        setOptionsToDefault()

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
//          item.background = resources.getDrawable(R.drawable.option_text_back)
            item.background = ContextCompat.getDrawable(this, R.drawable.option_text_back)
            item.typeface = Typeface.DEFAULT // BOLDなどもある
//          item.setTextColor(Color.parseColor("#ffffff")) こんな感じでテキストカラーも設定できたりする
        }
    }

    override fun onClick(v: View?) {
        val selectedOption = v as TextView
        val selectedOptionNum= when(v.id) {
            R.id.txtViewOption1 -> 1
            R.id.txtViewOption2 -> 2
            R.id.txtViewOption3 -> 3
            R.id.txtViewOption4 -> 4
            else -> 0
        }
        setSelectedOptionView(selectedOption, selectedOptionNum)
    }

    private fun setSelectedOptionView(selectedOption: TextView, selectedOptionNum: Int) {
        setOptionsToDefault()

        this.selectedOption = selectedOptionNum
        Log.d("selectedOptionNum", "$selectedOptionNum")


        selectedOption.background = ContextCompat.getDrawable(this, R.drawable.selected_option_text_back)
        selectedOption.typeface = Typeface.DEFAULT_BOLD
    }
}
