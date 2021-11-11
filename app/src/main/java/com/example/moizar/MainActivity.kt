package com.example.moizar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customBottomNavigationView1 : CustomBottomNavigationView1 = findViewById(R.id.customBottomBar)
        customBottomNavigationView1.inflateMenu(R.layout.bottom_menu)
    }
}