package com.example.moizar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.chip.Chip

class Profile_myappeal : AppCompatActivity() {
    private lateinit var myappeal_edit: EditText
    private lateinit var edit_num : TextView
    private lateinit var completebutton: Button
    private lateinit var Beforebutton: Button
    private var textnum : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_myappeal)
        myappeal_edit = findViewById(R.id.myappeal_edit)
        edit_num = findViewById(R.id.edit_num)
        completebutton = findViewById(R.id.step_4_next)
        Beforebutton = findViewById(R.id.step_4_before)

        completebutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        Beforebutton.setOnClickListener {
            val intent = Intent(this, Profile_interested_position::class.java)
            startActivity(intent)
            finish()
        }
        edit_set()
    }
    private fun edit_set() {
        textnum = myappeal_edit.length()
        myappeal_edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                textnum = p0!!.length
                edit_num.setText("$textnum/100")
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }
}