package com.example.moizar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton

class TeamsDetailApplyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams_detail_apply)

        val applyCloseBtn: AppCompatButton = findViewById(R.id.close)
        val msgSendBtn: AppCompatButton = findViewById(R.id.msg_send_btn)
        val applyIntent = Intent(this, ViewTeamsFragment::class.java)
        applyCloseBtn.setOnClickListener {
            finish()
        }

        msgSendBtn.setOnClickListener {
            finish()
        }
    }
}