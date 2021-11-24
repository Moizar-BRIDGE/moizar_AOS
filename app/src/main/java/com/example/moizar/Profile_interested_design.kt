package com.example.moizar

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.media.MediaCodec.MetricsConstants.MODE
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.Pair
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class Profile_interested_design : AppCompatActivity() {
    private  var chipnum : Int = 0
    private lateinit var complete_btn : Button
    private lateinit var design_view: ImageView
    private lateinit var design_text : TextView
    private lateinit var frame: FrameLayout
    private lateinit var disignchip_ux : Chip
    private lateinit var disignchip_graphic : Chip
    private lateinit var disignchip_character : Chip
    private lateinit var disignchip_illustration : Chip
    private lateinit var disignchip_BI : Chip
    private lateinit var disignchip_mobile : Chip
    private lateinit var disignchip_video : Chip
    private lateinit var disignchip_adver : Chip
    private lateinit var disignchip_product : Chip
    private lateinit var disignchip_fashion : Chip
    private lateinit var disignchip_3D : Chip
    private lateinit var disignchip_web : Chip
    private lateinit var chipGroup: ChipGroup
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_interested_design)
        frame = findViewById(R.id.frameLayout)
        design_text = findViewById(R.id.design_text)
        design_view = findViewById(R.id.design_view)
        complete_btn = findViewById(R.id.completebutton)
        disignchip_ux = findViewById(R.id.disignchip_ux)
        disignchip_graphic = findViewById(R.id.disignchip_graphic)
        disignchip_character = findViewById(R.id.disignchip_character)
        disignchip_illustration = findViewById(R.id.disignchip_illustration)
        disignchip_BI = findViewById(R.id.disignchip_BI)
        disignchip_mobile = findViewById(R.id.disignchip_mobile)
        disignchip_video = findViewById(R.id.disignchip_video)
        disignchip_adver = findViewById(R.id.disignchip_adver)
        disignchip_product = findViewById(R.id.disignchip_product)
        disignchip_fashion = findViewById(R.id.disignchip_fashion)
        disignchip_3D = findViewById(R.id.disignchip_3D)
        disignchip_web = findViewById(R.id.disignchip_web)
        chipGroup = findViewById(R.id.chipGroup)

        disignchip_ux.setOnClickListener {
            chipClick(disignchip_ux)
        }
        disignchip_graphic.setOnClickListener {
            chipClick(disignchip_graphic)
        }
        disignchip_character.setOnClickListener {
            chipClick(disignchip_character)
        }
        disignchip_illustration.setOnClickListener {
            chipClick(disignchip_illustration)
        }
        disignchip_BI.setOnClickListener {
            chipClick(disignchip_BI)
        }
        disignchip_mobile.setOnClickListener {
            chipClick(disignchip_mobile)
        }
        disignchip_video.setOnClickListener {
            chipClick(disignchip_video)
        }
        disignchip_adver.setOnClickListener {
            chipClick(disignchip_adver)
        }
        disignchip_product.setOnClickListener {
            chipClick(disignchip_product)
        }
        disignchip_fashion.setOnClickListener {
            chipClick(disignchip_fashion)
        }
        disignchip_3D.setOnClickListener {
            chipClick(disignchip_3D)
        }
        disignchip_web.setOnClickListener {
            chipClick(disignchip_web)
        }
        complete_btn.setOnClickListener {
            val intent = Intent(this, Profile_interested_position::class.java)
            var options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair.create(design_view, "imageTransition"),
                Pair.create(design_text, "imageTransition6"),
                Pair.create(frame, "imageTransition5"),
            )
            startActivity(intent, options.toBundle())
            Handler().postDelayed({finish() }, 2000)
        }
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun chipClick(chip : Chip) {
              if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                  if (chip.isSelected) {
                      chip.chipBackgroundColor = getColorStateList(R.color.white)
                      chip.setTextColor(getColorStateList(R.color.Step1_color))
                      chip.isSelected = false

                  } else if (!chip.isSelected) {
                      chip.chipBackgroundColor = getColorStateList(R.color.step3_click_chip_color)
                      chip.setTextColor(Color.WHITE)
                      chip.isEnabled = false
                      chip.isSelected = true
                      chipGroup.addView(Chip(this).apply {
                          isCloseIconVisible = true
                          chipnum++
                          text = chip.text
                          setOnCloseIconClickListener {
                              chip.chipBackgroundColor = getColorStateList(R.color.white)
                              chip.setTextColor(getColorStateList(R.color.Step1_color))
                              chipGroup.removeView(this)
                              chip.isEnabled = true
                              chip.isSelected = false
                              chipnum--
                          }
                      })
                  }
              }
    }
}
