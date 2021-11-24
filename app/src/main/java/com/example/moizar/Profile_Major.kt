package com.example.moizar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText

class Profile_Major : AppCompatActivity() {
    private lateinit var nextButton: Button
    private lateinit var beforeButton: Button
    private lateinit var college_name_edit: EditText
    private lateinit var major_edit: EditText
    private lateinit var email_edit: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_major)
        nextButton = findViewById(R.id.step_2_next)
        beforeButton = findViewById(R.id.step_2_before)
        college_name_edit = findViewById(R.id.college_name_edit)
        major_edit = findViewById(R.id.major_edit)
        email_edit = findViewById(R.id.email_edit)


        nextButton.setOnClickListener {
            val intent = Intent(this, Profile_interested_position::class.java)
            startActivity(intent)
            finish()
        }

        beforeButton.setOnClickListener {
            val intent = Intent(this, Profile_Name::class.java)
            startActivity(intent)
            finish()
        }
    }

}