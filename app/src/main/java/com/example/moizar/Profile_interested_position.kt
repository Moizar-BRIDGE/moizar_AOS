package com.example.moizar

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.Pair
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL

class Profile_interested_position : AppCompatActivity() {
    private lateinit var nextButton: Button
    private lateinit var beforeButton: Button
    private lateinit var design_button: ImageButton
    private lateinit var design_text: TextView
    private lateinit var developer_button: ImageButton
    private lateinit var developer_text: TextView
    private lateinit var marketing_button: ImageButton
    private lateinit var marketing_text: TextView
    private lateinit var etc_button: ImageButton
    private lateinit var etc_text: TextView
    private lateinit var frame: FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_interested_position)
        frame = findViewById(R.id.frameLayout)
        nextButton = findViewById(R.id.step_3_next)
        beforeButton = findViewById(R.id.step_3_before)
        design_button = findViewById(R.id.design_button)
        design_text = findViewById(R.id.design_text)
        developer_button = findViewById(R.id.developer_button)
        developer_text = findViewById(R.id.developer_text)
        marketing_button = findViewById(R.id.marketing_button)
        marketing_text = findViewById(R.id.marketing_text)
        etc_button = findViewById(R.id.etc_button)
        etc_text = findViewById(R.id.etc_text)

        nextButton.setOnClickListener {
            if(developer_button.isSelected){
                val intent = Intent(this, Profile_Name::class.java)
                startActivity(intent)
                finish()
            }
            if(marketing_button.isSelected){
                val intent = Intent(this, Profile_Name::class.java)
                startActivity(intent)
                finish()
            }
            if(etc_button.isSelected){
                val intent = Intent(this, Profile_Name::class.java)
                startActivity(intent)
                finish()
            }
        }

        design_button.setOnClickListener{
            design_button.isSelected = true
            developer_button.isSelected = false
            marketing_button.isSelected = false
            etc_button.isSelected = false
            developer_text.setTextColor(Color.GRAY)
            marketing_text.setTextColor(Color.GRAY)
            etc_text.setTextColor(Color.GRAY)
            if( design_button.isSelected){
                design_text.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.step3_text_color))
                val intent = Intent(this, Profile_interested_design::class.java)
                var options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    Pair.create(design_button, "imageTransition"),
                    Pair.create(design_text, "imageTransition6"),
                    Pair.create(frame, "imageTransition5"),
                )
                design_button.isSelected = false
                design_text.setTextColor(Color.GRAY)
                startActivity(intent, options.toBundle())
                Handler().postDelayed({finish() }, 2000)
            }
        }
        developer_button.setOnClickListener{
            design_button.isSelected = false
            developer_button.isSelected = true
            marketing_button.isSelected = false
            etc_button.isSelected = false
            design_text.setTextColor(Color.GRAY)
            marketing_text.setTextColor(Color.GRAY)
            etc_text.setTextColor(Color.GRAY)
            if( developer_button.isSelected){
                developer_text.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.step3_text_color))
                val intent = Intent(this, Profile_interested_design::class.java)
                var options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    Pair.create(developer_button, "imageTransition"),
                    Pair.create(developer_text, "imageTransition1"),
                    Pair.create(frame, "imageTransition2"),
                )
                startActivity(intent, options.toBundle())
                Handler().postDelayed({finish() }, 2000)
            }

        }
        marketing_button.setOnClickListener{
            design_button.isSelected = false
            developer_button.isSelected = false
            marketing_button.isSelected = true
            etc_button.isSelected = false
            design_text.setTextColor(Color.GRAY)
            developer_text.setTextColor(Color.GRAY)
            etc_text.setTextColor(Color.GRAY)
            if( marketing_button.isSelected){
                marketing_text.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.step3_text_color))
                val intent = Intent(this, Profile_interested_design::class.java)
                var options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    Pair.create(marketing_button, "imageTransition"),
                    Pair.create(marketing_text, "imageTransition1"),
                    Pair.create(frame, "imageTransition2"),
                )
                startActivity(intent, options.toBundle())
                Handler().postDelayed({finish() }, 2000)
            }

        }
        etc_button.setOnClickListener{
            design_button.isSelected = false
            developer_button.isSelected = false
            marketing_button.isSelected = false
            etc_button.isSelected = true
            design_text.setTextColor(Color.GRAY)
            developer_text.setTextColor(Color.GRAY)
            marketing_text.setTextColor(Color.GRAY)
            if( etc_button.isSelected){
                etc_text.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.step3_text_color))
                marketing_text.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.step3_text_color))
                val intent = Intent(this, Profile_interested_design::class.java)
                var options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    Pair.create(etc_button, "imageTransition"),
                    Pair.create(etc_text, "imageTransition1"),
                    Pair.create(frame, "imageTransition2"),
                )
                startActivity(intent, options.toBundle())
                Handler().postDelayed({finish() }, 2000)
            }

        }
        beforeButton.setOnClickListener {

        }
        }
}