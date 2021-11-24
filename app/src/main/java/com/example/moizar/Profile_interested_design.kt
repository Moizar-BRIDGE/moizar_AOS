package com.example.moizar

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class Profile_interested_design : AppCompatActivity() {
    private  var chipnum : Int = 0
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
        chipClick()
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun chipClick() {
        disignchip_ux.setOnClickListener {
              if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                  if (disignchip_ux.isSelected) {
                      disignchip_ux.chipBackgroundColor = getColorStateList(R.color.white)
                      disignchip_ux.setTextColor(getColorStateList(R.color.Step1_color))
                      disignchip_ux.isSelected = false

                  } else if (!disignchip_ux.isSelected) {
                      disignchip_ux.chipBackgroundColor =
                          getColorStateList(R.color.step3_click_chip_color)
                      disignchip_ux.setTextColor(Color.WHITE)
                      disignchip_ux.isEnabled = false
                      disignchip_ux.isSelected = true

                      chipGroup.addView(Chip(this).apply {
                          isCloseIconVisible = true
                          chipnum++
                          text = disignchip_ux.text
                          setOnCloseIconClickListener {
                              disignchip_ux.chipBackgroundColor = getColorStateList(R.color.white)
                              disignchip_ux.setTextColor(getColorStateList(R.color.Step1_color))
                              chipGroup.removeView(this)
                              disignchip_ux.isEnabled = true
                              disignchip_ux.isSelected = false
                              chipnum--
                          }
                      })
                  }
              }
        }
        disignchip_graphic.setOnClickListener {
            if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                if (disignchip_graphic.isSelected) {
                    disignchip_graphic.chipBackgroundColor = getColorStateList(R.color.white)
                    disignchip_graphic.setTextColor(getColorStateList(R.color.Step1_color))
                    disignchip_graphic.isSelected = false

                } else if (!disignchip_graphic.isSelected) {
                    disignchip_graphic.chipBackgroundColor =
                        getColorStateList(R.color.step3_click_chip_color)
                    disignchip_graphic.setTextColor(Color.WHITE)
                    disignchip_graphic.isEnabled = false
                    disignchip_graphic.isSelected = true
                    chipGroup.addView(Chip(this).apply {
                        isCloseIconVisible = true
                        chipnum++
                        text = disignchip_graphic.text

                        setOnCloseIconClickListener {
                            disignchip_graphic.chipBackgroundColor =
                                getColorStateList(R.color.white)
                            disignchip_graphic.setTextColor(getColorStateList(R.color.Step1_color))
                            chipGroup.removeView(this)
                            disignchip_graphic.isEnabled = true
                            disignchip_graphic.isSelected = false
                            chipnum--
                        }
                    })
                }
            }
        }
        disignchip_character.setOnClickListener {
             if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                 if (disignchip_character.isSelected) {
                     disignchip_character.chipBackgroundColor = getColorStateList(R.color.white)
                     disignchip_character.setTextColor(getColorStateList(R.color.Step1_color))
                     disignchip_character.isSelected = false

                 } else if (!disignchip_character.isSelected) {
                     disignchip_character.chipBackgroundColor =
                         getColorStateList(R.color.step3_click_chip_color)
                     disignchip_character.setTextColor(Color.WHITE)
                     disignchip_character.isEnabled = false
                     disignchip_character.isSelected = true

                         chipGroup.addView(Chip(this).apply {
                             isCloseIconVisible = true
                             chipnum++
                             text = disignchip_character.text
                             setOnCloseIconClickListener {
                                 disignchip_character.chipBackgroundColor =
                                     getColorStateList(R.color.white)
                                 disignchip_character.setTextColor(getColorStateList(R.color.Step1_color))
                                 chipGroup.removeView(this)
                                 disignchip_character.isEnabled = true
                                 disignchip_character.isSelected = false
                                 chipnum--
                             }
                         })
                 }
             }
        }
        disignchip_graphic.setOnClickListener {
             if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                 if (disignchip_graphic.isSelected) {
                     disignchip_graphic.chipBackgroundColor = getColorStateList(R.color.white)
                     disignchip_graphic.setTextColor(getColorStateList(R.color.Step1_color))
                     disignchip_graphic.isSelected = false

                 } else if (!disignchip_graphic.isSelected) {
                     disignchip_graphic.chipBackgroundColor = getColorStateList(R.color.step3_click_chip_color)
                     disignchip_graphic.setTextColor(Color.WHITE)
                     disignchip_graphic.isEnabled = false
                     disignchip_graphic.isSelected = true

                     chipGroup.addView(Chip(this).apply {
                         isCloseIconVisible = true
                         chipnum++
                         text = disignchip_graphic.text
                         setOnCloseIconClickListener {
                             disignchip_graphic.chipBackgroundColor =
                                 getColorStateList(R.color.white)
                             disignchip_graphic.setTextColor(getColorStateList(R.color.Step1_color))
                             chipGroup.removeView(this)
                             disignchip_graphic.isEnabled = true
                             disignchip_graphic.isSelected = false
                             chipnum--
                         }
                     })
                 }
             }
        }
        disignchip_graphic.setOnClickListener {
             if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                 if (disignchip_graphic.isSelected) {
                     disignchip_graphic.chipBackgroundColor = getColorStateList(R.color.white)
                     disignchip_graphic.setTextColor(getColorStateList(R.color.Step1_color))
                     disignchip_graphic.isSelected = false

                 } else if (!disignchip_graphic.isSelected) {
                     disignchip_graphic.chipBackgroundColor =
                         getColorStateList(R.color.step3_click_chip_color)
                     disignchip_graphic.setTextColor(Color.WHITE)
                     disignchip_graphic.isEnabled = false
                     disignchip_graphic.isSelected = true


                     chipGroup.addView(Chip(this).apply {
                         isCloseIconVisible = true
                         chipnum++
                         text = disignchip_graphic.text
                         setOnCloseIconClickListener {
                             disignchip_graphic.chipBackgroundColor =
                                 getColorStateList(R.color.white)
                             disignchip_graphic.setTextColor(getColorStateList(R.color.Step1_color))
                             chipGroup.removeView(this)
                             disignchip_graphic.isEnabled = true
                             disignchip_graphic.isSelected = false
                             chipnum--
                         }
                     })
                 }
             }
        }
        disignchip_illustration.setOnClickListener {
             if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                 if (disignchip_illustration.isSelected) {
                     disignchip_illustration.chipBackgroundColor = getColorStateList(R.color.white)
                     disignchip_illustration.setTextColor(getColorStateList(R.color.Step1_color))
                     disignchip_illustration.isSelected = false

                 } else if (!disignchip_illustration.isSelected) {
                     disignchip_illustration.chipBackgroundColor =
                         getColorStateList(R.color.step3_click_chip_color)
                     disignchip_illustration.setTextColor(Color.WHITE)
                     disignchip_illustration.isEnabled = false
                     disignchip_illustration.isSelected = true

                     chipGroup.addView(Chip(this).apply {
                         isCloseIconVisible = true
                         chipnum++
                         text = disignchip_illustration.text
                         setOnCloseIconClickListener {
                             disignchip_illustration.chipBackgroundColor =
                                 getColorStateList(R.color.white)
                             disignchip_illustration.setTextColor(getColorStateList(R.color.Step1_color))
                             chipGroup.removeView(this)
                             disignchip_illustration.isEnabled = true
                             disignchip_illustration.isSelected = false
                             chipnum--
                         }
                     })
                 }
             }
        }
        disignchip_BI.setOnClickListener {
            if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                if (disignchip_BI.isSelected) {
                    disignchip_BI.chipBackgroundColor = getColorStateList(R.color.white)
                    disignchip_BI.setTextColor(getColorStateList(R.color.Step1_color))
                    disignchip_BI.isSelected = false

                } else if (!disignchip_BI.isSelected) {
                    disignchip_BI.chipBackgroundColor =
                        getColorStateList(R.color.step3_click_chip_color)
                    disignchip_BI.setTextColor(Color.WHITE)
                    disignchip_BI.isEnabled = false
                    disignchip_BI.isSelected = true

                    chipGroup.addView(Chip(this).apply {
                        isCloseIconVisible = true
                        chipnum++
                        text = disignchip_BI.text
                        setOnCloseIconClickListener {
                            disignchip_BI.chipBackgroundColor = getColorStateList(R.color.white)
                            disignchip_BI.setTextColor(getColorStateList(R.color.Step1_color))
                            chipGroup.removeView(this)
                            disignchip_BI.isEnabled = true
                            disignchip_BI.isSelected = false
                            chipnum--
                        }
                    })
                }
            }
        }
        disignchip_mobile.setOnClickListener {
            if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                if (disignchip_mobile.isSelected) {
                    disignchip_mobile.chipBackgroundColor = getColorStateList(R.color.white)
                    disignchip_mobile.setTextColor(getColorStateList(R.color.Step1_color))
                    disignchip_mobile.isSelected = false

                } else if (!disignchip_mobile.isSelected) {
                    disignchip_mobile.chipBackgroundColor =
                        getColorStateList(R.color.step3_click_chip_color)
                    disignchip_mobile.setTextColor(Color.WHITE)
                    disignchip_mobile.isEnabled = false
                    disignchip_mobile.isSelected = true

                    chipGroup.addView(Chip(this).apply {
                        isCloseIconVisible = true
                        chipnum++
                        text = disignchip_mobile.text
                        setOnCloseIconClickListener {
                            disignchip_mobile.chipBackgroundColor = getColorStateList(R.color.white)
                            disignchip_mobile.setTextColor(getColorStateList(R.color.Step1_color))
                            chipGroup.removeView(this)
                            disignchip_mobile.isEnabled = true
                            disignchip_mobile.isSelected = false
                            chipnum--
                        }
                    })
                }
            }
        }
        disignchip_video.setOnClickListener {
            if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                if (disignchip_video.isSelected) {
                    disignchip_video.chipBackgroundColor = getColorStateList(R.color.white)
                    disignchip_video.setTextColor(getColorStateList(R.color.Step1_color))
                    disignchip_video.isSelected = false

                } else if (!disignchip_video.isSelected) {
                    disignchip_video.chipBackgroundColor =
                        getColorStateList(R.color.step3_click_chip_color)
                    disignchip_video.setTextColor(Color.WHITE)
                    disignchip_video.isEnabled = false
                    disignchip_video.isSelected = true

                    chipGroup.addView(Chip(this).apply {
                        isCloseIconVisible = true
                        chipnum++
                        text = disignchip_video.text
                        setOnCloseIconClickListener {
                            disignchip_video.chipBackgroundColor = getColorStateList(R.color.white)
                            disignchip_video.setTextColor(getColorStateList(R.color.Step1_color))
                            chipGroup.removeView(this)
                            disignchip_video.isEnabled = true
                            disignchip_video.isSelected = false
                            chipnum--
                        }
                    })
                }
            }
        }
        disignchip_adver.setOnClickListener {
            if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                if (disignchip_adver.isSelected) {
                    disignchip_adver.chipBackgroundColor = getColorStateList(R.color.white)
                    disignchip_adver.setTextColor(getColorStateList(R.color.Step1_color))
                    disignchip_adver.isSelected = false

                } else if (!disignchip_adver.isSelected) {
                    disignchip_adver.chipBackgroundColor =
                        getColorStateList(R.color.step3_click_chip_color)
                    disignchip_adver.setTextColor(Color.WHITE)
                    disignchip_adver.isEnabled = false
                    disignchip_adver.isSelected = true

                    chipGroup.addView(Chip(this).apply {
                        isCloseIconVisible = true
                        chipnum++
                        text = disignchip_adver.text
                        setOnCloseIconClickListener {
                            disignchip_adver.chipBackgroundColor = getColorStateList(R.color.white)
                            disignchip_adver.setTextColor(getColorStateList(R.color.Step1_color))
                            chipGroup.removeView(this)
                            disignchip_adver.isEnabled = true
                            disignchip_adver.isSelected = false
                            chipnum--
                        }
                    })
                }
            }
        }
        disignchip_product.setOnClickListener {
            if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                if (disignchip_product.isSelected) {
                    disignchip_product.chipBackgroundColor = getColorStateList(R.color.white)
                    disignchip_product.setTextColor(getColorStateList(R.color.Step1_color))
                    disignchip_product.isSelected = false

                } else if (!disignchip_product.isSelected) {
                    disignchip_product.chipBackgroundColor =
                        getColorStateList(R.color.step3_click_chip_color)
                    disignchip_product.setTextColor(Color.WHITE)
                    disignchip_product.isEnabled = false
                    disignchip_product.isSelected = true

                    chipGroup.addView(Chip(this).apply {
                        isCloseIconVisible = true
                        chipnum++
                        text = disignchip_product.text
                        setOnCloseIconClickListener {
                            disignchip_product.chipBackgroundColor =
                                getColorStateList(R.color.white)
                            disignchip_product.setTextColor(getColorStateList(R.color.Step1_color))
                            chipGroup.removeView(this)
                            disignchip_product.isEnabled = true
                            disignchip_product.isSelected = false
                            chipnum--
                        }
                    })
                }
            }
        }
        disignchip_fashion.setOnClickListener {
            if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                if (disignchip_fashion.isSelected) {
                    disignchip_fashion.chipBackgroundColor = getColorStateList(R.color.white)
                    disignchip_fashion.setTextColor(getColorStateList(R.color.Step1_color))
                    disignchip_fashion.isSelected = false

                } else if (!disignchip_fashion.isSelected) {
                    disignchip_fashion.chipBackgroundColor =
                        getColorStateList(R.color.step3_click_chip_color)
                    disignchip_fashion.setTextColor(Color.WHITE)
                    disignchip_fashion.isEnabled = false
                    disignchip_fashion.isSelected = true

                    chipGroup.addView(Chip(this).apply {
                        isCloseIconVisible = true
                        chipnum++
                        text = disignchip_fashion.text
                        setOnCloseIconClickListener {
                            disignchip_fashion.chipBackgroundColor =
                                getColorStateList(R.color.white)
                            disignchip_fashion.setTextColor(getColorStateList(R.color.Step1_color))
                            chipGroup.removeView(this)
                            disignchip_fashion.isEnabled = true
                            disignchip_fashion.isSelected = false
                            chipnum--
                        }
                    })
                }
            }
        }
        disignchip_3D.setOnClickListener {
            if(chipnum >= 5)
                {
                    Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
                }
            else {
                if (disignchip_3D.isSelected) {
                    disignchip_3D.chipBackgroundColor = getColorStateList(R.color.white)
                    disignchip_3D.setTextColor(getColorStateList(R.color.Step1_color))
                    disignchip_3D.isSelected = false

                } else if (!disignchip_3D.isSelected) {
                    disignchip_3D.chipBackgroundColor =
                        getColorStateList(R.color.step3_click_chip_color)
                    disignchip_3D.setTextColor(Color.WHITE)
                    disignchip_3D.isEnabled = false
                    disignchip_3D.isSelected = true

                    chipGroup.addView(Chip(this).apply {
                        isCloseIconVisible = true
                        chipnum++
                        text = disignchip_3D.text
                        setOnCloseIconClickListener {
                            disignchip_3D.chipBackgroundColor = getColorStateList(R.color.white)
                            disignchip_3D.setTextColor(getColorStateList(R.color.Step1_color))
                            chipGroup.removeView(this)
                            disignchip_3D.isEnabled = true
                            disignchip_3D.isSelected = false
                            chipnum--
                        }
                    })
                }
            }
        }
        disignchip_web.setOnClickListener {
            if (chipnum >= 5) {
                Toast.makeText(this, "선택 할 수 있는 카테고리는 최대 5개 입니다.", Toast.LENGTH_SHORT).show()
            } else {
                if (disignchip_web.isSelected) {
                    disignchip_web.chipBackgroundColor = getColorStateList(R.color.white)
                    disignchip_web.setTextColor(getColorStateList(R.color.Step1_color))
                    disignchip_web.isSelected = false

                } else if (!disignchip_web.isSelected) {
                    disignchip_web.chipBackgroundColor =
                        getColorStateList(R.color.step3_click_chip_color)
                    disignchip_web.setTextColor(Color.WHITE)
                    disignchip_web.isEnabled = false
                    disignchip_web.isSelected = true

                    chipGroup.addView(Chip(this).apply {
                        isCloseIconVisible = true
                        chipnum++
                        text = disignchip_web.text
                        setOnCloseIconClickListener {
                            disignchip_web.chipBackgroundColor = getColorStateList(R.color.white)
                            disignchip_web.setTextColor(getColorStateList(R.color.Step1_color))
                            chipGroup.removeView(this)
                            disignchip_web.isEnabled = true
                            disignchip_web.isSelected = false
                            chipnum--
                        }
                    })
                }
            }
        }
    }
}
