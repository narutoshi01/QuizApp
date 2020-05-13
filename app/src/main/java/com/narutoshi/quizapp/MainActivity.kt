package com.narutoshi.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            txtInputLayoutName.error = null
            if (editTextName.text.toString().isEmpty()) {
                txtInputLayoutName.error = "Please enter your name"
            } else {
                val intent = Intent(this, QuestionActivity::class.java).apply {
                    putExtra(IntentKey.USER_NAME.name, editTextName.text.toString())
                }
                startActivity(intent)
                finish()
            }
        }
    }
}
