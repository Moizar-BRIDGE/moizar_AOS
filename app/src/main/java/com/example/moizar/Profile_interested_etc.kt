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

class Profile_interested_etc : AppCompatActivity() {
    private var chipnum: Int = 0
    private lateinit var complete_btn: Button
    private lateinit var direc_btn: Button
    private lateinit var etc_view: ImageView
    private lateinit var etc_text: TextView
    private lateinit var frame: FrameLayout
    private lateinit var etc_contents: Chip
    private lateinit var etc_editer: Chip
    private lateinit var etc_video_edit: Chip
    private lateinit var etc_video_prod: Chip
    private lateinit var etc_Translation: Chip
    private lateinit var etc_game_plan: Chip
    private lateinit var etc_game_cli: Chip
    private lateinit var etc_uni: Chip
    private lateinit var etc_game_gra: Chip
    private lateinit var etc_game_server: Chip
    private lateinit var etc_game_mob: Chip
    private lateinit var etc_pd: Chip
    private lateinit var etc_game_art: Chip
    private lateinit var etc_writer: Chip
    private lateinit var chipGroup: ChipGroup
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_interested_etc)
        frame = findViewById(R.id.frameLayout)
        etc_text = findViewById(R.id.etc_text)
        etc_view = findViewById(R.id.etc_view)
        direc_btn = findViewById(R.id.direc_btn)
        complete_btn = findViewById(R.id.completebutton)
        etc_contents = findViewById(R.id.etc_contents)
        etc_editer = findViewById(R.id.etc_editer)
        etc_video_edit = findViewById(R.id.etc_video_edit)
        etc_video_prod = findViewById(R.id.etc_video_prod)
        etc_Translation = findViewById(R.id.etc_Translation)
        etc_game_plan = findViewById(R.id.etc_game_plan)
        etc_game_cli = findViewById(R.id.etc_game_cli)
        etc_uni = findViewById(R.id.etc_uni)
        etc_game_gra = findViewById(R.id.etc_game_gra)
        etc_game_server = findViewById(R.id.etc_game_server)
        etc_game_mob = findViewById(R.id.etc_game_mob)
        etc_pd = findViewById(R.id.etc_pd)
        etc_game_art = findViewById(R.id.etc_game_art)
        etc_writer = findViewById(R.id.etc_writer)
        chipGroup = findViewById(R.id.chipGroup)

        etc_contents.setOnClickListener {
            chipClick(etc_contents)
        }
        etc_editer.setOnClickListener {
            chipClick(etc_editer)
        }
        etc_video_edit.setOnClickListener {
            chipClick(etc_video_edit)
        }
        etc_video_prod.setOnClickListener {
            chipClick(etc_video_prod)
        }
        etc_Translation.setOnClickListener {
            chipClick(etc_Translation)
        }
        etc_game_plan.setOnClickListener {
            chipClick(etc_game_plan)
        }
        etc_game_cli.setOnClickListener {
            chipClick(etc_game_cli)
        }
        etc_uni.setOnClickListener {
            chipClick(etc_uni)
        }
        etc_game_gra.setOnClickListener {
            chipClick(etc_game_gra)
        }
        etc_game_server.setOnClickListener {
            chipClick(etc_game_server)
        }
        etc_game_mob.setOnClickListener {
            chipClick(etc_game_mob)
        }
        etc_pd.setOnClickListener {
            chipClick(etc_pd)
        }
        etc_game_art.setOnClickListener {
            chipClick(etc_game_art)
        }
        etc_writer.setOnClickListener {
            chipClick(etc_writer)
        }
        direc_btn.setOnClickListener {
            val intent = Intent(this, Profile_interested_etc_direct::class.java)
            startActivity(intent)
            finish()
        }
        complete_btn.setOnClickListener {
            val intent = Intent(this, Profile_interested_position::class.java)
            var options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair.create(etc_view, "imageTransition4"),
                Pair.create(etc_text, "imageTransition9"),
                Pair.create(frame, "imageTransition5"),
            )
            startActivity(intent, options.toBundle())
            Handler().postDelayed({ finish() }, 2000)
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
