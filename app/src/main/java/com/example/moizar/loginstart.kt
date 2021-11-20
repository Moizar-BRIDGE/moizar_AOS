package com.example.moizar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.facebook.login.widget.LoginButton

class loginstart : AppCompatActivity() {
    private lateinit var StratButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginstart)
        StratButton = findViewById(R.id.Strat)
        StratButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}