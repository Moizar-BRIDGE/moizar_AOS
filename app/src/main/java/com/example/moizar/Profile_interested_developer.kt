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

class Profile_interested_developer : AppCompatActivity() {
    private  var chipnum : Int = 0
    private lateinit var complete_btn : Button
    private lateinit var developer_view: ImageView
    private lateinit var developer_text : TextView
    private lateinit var frame: FrameLayout
    private lateinit var developer_data : Chip
    private lateinit var developer_soft : Chip
    private lateinit var developer_front : Chip
    private lateinit var developer_system : Chip
    private lateinit var developer_java : Chip
    private lateinit var developer_server : Chip
    private lateinit var developer_android : Chip
    private lateinit var developer_ios : Chip
    private lateinit var developer_python : Chip
    private lateinit var developer_devops : Chip
    private lateinit var developer_node_js : Chip
    private lateinit var developer_network : Chip
    private lateinit var developer_c : Chip
    private lateinit var developer_cflus : Chip
    private lateinit var developer_machine : Chip
    private lateinit var developer_web : Chip
    private lateinit var chipGroup: ChipGroup
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_interested_developer)
        frame = findViewById(R.id.frameLayout)
        developer_text = findViewById(R.id.developer_text)
        developer_view = findViewById(R.id.developer_view)
        complete_btn = findViewById(R.id.completebutton)
        developer_data = findViewById(R.id.developer_data)
        developer_soft = findViewById(R.id.developer_soft)
        developer_front = findViewById(R.id.developer_front)
        developer_system = findViewById(R.id.developer_system)
        developer_java = findViewById(R.id.developer_java)
        developer_server = findViewById(R.id.developer_server)
        developer_android = findViewById(R.id.developer_android)
        developer_ios = findViewById(R.id.developer_ios)
        developer_python = findViewById(R.id.developer_python)
        developer_devops = findViewById(R.id.developer_devops)
        developer_node_js = findViewById(R.id.developer_node_js)
        developer_network = findViewById(R.id.developer_network)
        developer_c = findViewById(R.id.developer_c)
        developer_cflus = findViewById(R.id.developer_cflus)
        developer_machine = findViewById(R.id.developer_machine)
        developer_web = findViewById(R.id.developer_web)
        chipGroup = findViewById(R.id.chipGroup)

        developer_data.setOnClickListener {
            chipClick(developer_data)
        }
        developer_soft.setOnClickListener {
            chipClick(developer_soft)
        }
        developer_front.setOnClickListener {
            chipClick(developer_front)
        }
        developer_system.setOnClickListener {
            chipClick(developer_system)
        }
        developer_java.setOnClickListener {
            chipClick(developer_java)
        }
        developer_server.setOnClickListener {
            chipClick(developer_server)
        }
        developer_android.setOnClickListener {
            chipClick(developer_android)
        }
        developer_ios.setOnClickListener {
            chipClick(developer_ios)
        }
        developer_python.setOnClickListener {
            chipClick(developer_python)
        }
        developer_devops.setOnClickListener {
            chipClick(developer_devops)
        }
        developer_node_js.setOnClickListener {
            chipClick(developer_node_js)
        }
        developer_network.setOnClickListener {
            chipClick(developer_network)
        }
        developer_c.setOnClickListener {
            chipClick(developer_c)
        }
        developer_cflus.setOnClickListener {
            chipClick(developer_cflus)
        }
        developer_machine.setOnClickListener {
            chipClick(developer_machine)
        }
        developer_web.setOnClickListener {
            chipClick(developer_web)
        }

        complete_btn.setOnClickListener {
            val intent = Intent(this, Profile_interested_position::class.java)
            var options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair.create(developer_view, "imageTransition"),
                Pair.create(developer_text, "imageTransition6"),
                Pair.create(frame, "imageTransition5"),
            )
            startActivity(intent, options.toBundle())
            Handler().postDelayed({finish() }, 2000)
        }
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun chipClick(chipkind : Chip) {
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
