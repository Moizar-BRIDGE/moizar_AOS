package com.example.moizar

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class Profile_interested_etc_direct : AppCompatActivity() {
    private lateinit var direc_edit: EditText
    private lateinit var completebutton: Button
    private lateinit var dir_before_btn: Button
    private var chipnum: Int = 0
    private var textnum : Int = 0
    private lateinit var edit_num : TextView
    private lateinit var edit_string : CharSequence
    private lateinit var chipGroup: ChipGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_intersted_etc_direct)
        edit_num = findViewById(R.id.edit_num)
        chipGroup = findViewById(R.id.chipGroup)
        direc_edit = findViewById(R.id.direc_edit)
        completebutton = findViewById(R.id.completebutton)
        dir_before_btn = findViewById(R.id.dir_before_btn)
        dir_before_btn.setOnClickListener {
            val intent = Intent(this, Profile_interested_etc::class.java)
            startActivity(intent)
            finish()
        }
        edit_set()
    }
    private fun edit_set() {
        edit_string = direc_edit.text
        textnum = direc_edit.length()
        direc_edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                textnum = p0!!.length
                edit_num.setText("$textnum/10")
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
        completebutton.setOnClickListener {
            if(chipnum >= 5 ){
                Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
            }
            else if(direc_edit.length() == 0){
                Toast.makeText(this, "원하는 카테고리를 1글자 이상 입력하세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                val chip = Chip(this).apply {
                    text = edit_string
                    isCloseIconVisible = true
                    chipnum++
                    setOnCloseIconClickListener {
                        chipGroup.removeView(this)
                    }
                }
                chipGroup.addView(chip)
            }
        }
    }
}