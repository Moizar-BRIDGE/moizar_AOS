package com.example.moizar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TeamsWriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams_write)

        val writeViewClearBtn: FloatingActionButton = findViewById(R.id.write_view_clear_btn)


        writeViewClearBtn.setOnClickListener {
            finish()
        }


    }
}