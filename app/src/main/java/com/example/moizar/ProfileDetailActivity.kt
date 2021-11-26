package com.example.moizar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ProfileDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)

        val profileDetailBackBtn: ImageButton = findViewById(R.id.profile_detail_back_btn)

        profileDetailBackBtn.setOnClickListener {
            finish()
        }
    }
}