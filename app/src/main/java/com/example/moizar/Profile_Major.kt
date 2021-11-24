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
    private  var chip0 : CharSequence = ""
    private  var chip1 : CharSequence = ""
    private  var chip2 : CharSequence = ""
    private  var chip3 : CharSequence = ""
    private  var chip4 : CharSequence = ""
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
            intent.putExtra("chip0", chip0);
            intent.putExtra("chip1", chip1);
            intent.putExtra("chip2", chip2);
            intent.putExtra("chip3", chip3);
            intent.putExtra("chip4", chip4);
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