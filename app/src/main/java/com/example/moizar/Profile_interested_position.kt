package com.example.moizar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL

class Profile_interested_position : AppCompatActivity() {
    private lateinit var nextButton: Button
    private lateinit var beforeButton: Button
    private lateinit var design_CardView: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_interested_position)

        nextButton = findViewById(R.id.step_3_next)
        beforeButton = findViewById(R.id.step_3_before)
        design_CardView = findViewById(R.id.design_CardView)
        nextButton.setOnClickListener {
            val intent = Intent(this, Logout::class.java)
            startActivity(intent)
            finish()
        }
        design_CardView.setOnClickListener{

        }
        beforeButton.setOnClickListener {
            val intent = Intent(this, Profile_Name::class.java)
            startActivity(intent)
            finish()
        }
        }
}