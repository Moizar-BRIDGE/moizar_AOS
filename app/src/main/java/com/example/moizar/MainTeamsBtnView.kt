package com.example.moizar

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

class MainTeamsBtnView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {
//        private val dateFormat = SimpleDateFormat("yy/MM/dd HH:mm")
    }

    init {
        inflate(context, R.layout.teams_main_btn, this)
    }

}