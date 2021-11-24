package com.example.moizar

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.util.Pair as UtilPair


class loginstart : AppCompatActivity() {
    private lateinit var StratButton : Button
    private lateinit var imoview : View
    private lateinit var imoview1 : View
    private lateinit var imoview2 : TextView
    private lateinit var imoview3 : ImageView
    private lateinit var imoview4 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginstart)
        StratButton = findViewById(R.id.googleSignInBtn)
        imoview = findViewById(R.id.group_3)
        imoview1 = findViewById(R.id.rectangle_5)
        imoview2 = findViewById(R.id.logintext)
        imoview3 = findViewById(R.id.welcome)
        imoview4 = findViewById(R.id.googleSignInBtn)
        StratButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            var options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                this,
                UtilPair.create(imoview, "imageTransition"),
                UtilPair.create(imoview2, "imageTransition2"),
                UtilPair.create(imoview3, "imageTransition3"),
                UtilPair.create(imoview4, "imageTransition4")
            )
            startActivity(intent, options.toBundle())
            Handler().postDelayed({finish() }, 2000)
        }
    }
}