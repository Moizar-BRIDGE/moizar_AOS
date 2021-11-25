package com.example.moizar

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Pair
import android.widget.*
import androidx.annotation.RequiresApi
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class Profile_interested_marketing : AppCompatActivity() {
    private var chipnum: Int = 0
    private lateinit var complete_btn: Button
    private lateinit var marketing_view: ImageView
    private lateinit var marketing_text: TextView
    private lateinit var frame: FrameLayout
    private lateinit var marketing_service: Chip
    private lateinit var marketing_business: Chip
    private lateinit var marketing_pmpo: Chip
    private lateinit var marketing_strategy: Chip
    private lateinit var marketing_operation: Chip
    private lateinit var marketing_manage: Chip
    private lateinit var marketing_data: Chip
    private lateinit var marketing_digital: Chip
    private lateinit var marketing_perform: Chip
    private lateinit var marketing_contents: Chip
    private lateinit var marketing_marketing_strategy: Chip
    private lateinit var marketing_brand: Chip
    private lateinit var marketing_adver: Chip
    private lateinit var chipGroup: ChipGroup
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_interested_marketing)
        frame = findViewById(R.id.frameLayout)
        marketing_text = findViewById(R.id.marketing_text)
        marketing_view = findViewById(R.id.marketing_view)
        complete_btn = findViewById(R.id.completebutton)
        marketing_service = findViewById(R.id.marketing_service)
        marketing_business = findViewById(R.id.marketing_business)
        marketing_pmpo = findViewById(R.id.marketing_pmpo)
        marketing_strategy = findViewById(R.id.marketing_strategy)
        marketing_operation = findViewById(R.id.marketing_operation)
        marketing_manage = findViewById(R.id.marketing_manage)
        marketing_data = findViewById(R.id.marketing_data)
        marketing_digital = findViewById(R.id.marketing_digital)
        marketing_perform = findViewById(R.id.marketing_perform)
        marketing_contents = findViewById(R.id.marketing_contents)
        marketing_marketing_strategy = findViewById(R.id.marketing_marketing_strategy)
        marketing_brand = findViewById(R.id.marketing_brand)
        marketing_adver = findViewById(R.id.marketing_adver)
        chipGroup = findViewById(R.id.chipGroup)

        marketing_service.setOnClickListener {
            chipClick(marketing_service)
        }
        marketing_business.setOnClickListener {
            chipClick(marketing_business)
        }
        marketing_pmpo.setOnClickListener {
            chipClick(marketing_pmpo)
        }
        marketing_strategy.setOnClickListener {
            chipClick(marketing_strategy)
        }
        marketing_operation.setOnClickListener {
            chipClick(marketing_operation)
        }
        marketing_manage.setOnClickListener {
            chipClick(marketing_manage)
        }
        marketing_data.setOnClickListener {
            chipClick(marketing_data)
        }
        marketing_digital.setOnClickListener {
            chipClick(marketing_digital)
        }
        marketing_perform.setOnClickListener {
            chipClick(marketing_perform)
        }
        marketing_contents.setOnClickListener {
            chipClick(marketing_contents)
        }
        marketing_marketing_strategy.setOnClickListener {
            chipClick(marketing_marketing_strategy)
        }
        marketing_brand.setOnClickListener {
            chipClick(marketing_brand)
        }
        marketing_adver.setOnClickListener {
            chipClick(marketing_adver)
        }

        complete_btn.setOnClickListener {
            val intent = Intent(this, Profile_interested_position::class.java)
            var options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair.create(marketing_view, "imageTransition3"),
                Pair.create(marketing_text, "imageTransition8"),
                Pair.create(frame, "imageTransition5"),
            )
            startActivity(intent, options.toBundle())
            Handler().postDelayed({ finish() }, 2000)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun chipClick(chipkind: Chip) {
        if (chipnum >= 5) {
            Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
        } else {
            if (chipkind.isSelected) {
                chipkind.chipBackgroundColor = getColorStateList(R.color.white)
                chipkind.setTextColor(getColorStateList(R.color.Step1_color))
                chipkind.isSelected = false

            } else if (!chipkind.isSelected) {
                chipkind.chipBackgroundColor = getColorStateList(R.color.step3_click_chip_color)
                chipkind.setTextColor(Color.WHITE)
                chipkind.isEnabled = false
                chipkind.isSelected = true
                chipGroup.addView(Chip(this).apply {
                    isCloseIconVisible = true
                    chipnum++
                    text = chipkind.text
                    setOnCloseIconClickListener {
                        chipkind.chipBackgroundColor = getColorStateList(R.color.white)
                        chipkind.setTextColor(getColorStateList(R.color.Step1_color))
                        chipGroup.removeView(this)
                        chipkind.isEnabled = true
                        chipkind.isSelected = false
                        chipnum--
                    }
                })
            }
        }
    }
}