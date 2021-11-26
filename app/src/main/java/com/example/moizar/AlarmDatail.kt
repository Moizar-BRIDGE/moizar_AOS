package com.example.moizar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class AlarmDatail : AppCompatActivity() {
    private lateinit var agree : Button
    private lateinit var disagree : Button
    private lateinit var user_image : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_datail)
        user_image = findViewById(R.id.ellipse_68)
        Glide.with(this).load(R.drawable.img_profile_test).circleCrop().into(user_image)
        agree = findViewById(R.id.agree)
        disagree = findViewById(R.id.disagree)
        agree.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
            finish()
        }
        disagree.setOnClickListener {
            val intent = Intent(this, AlarmActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}