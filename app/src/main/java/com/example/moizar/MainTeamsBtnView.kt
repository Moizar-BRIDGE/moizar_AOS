package com.example.moizar

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class MainTeamsBtnView @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    : LinearLayout(context, attrs, defStyleAttr){

    companion object{
//        private val dateFormat = SimpleDateFormat("yy/MM/dd HH:mm")
    }

    init{
        inflate(context, R.layout.teams_main_btn, this)
    }

//    fun setAlarmDate(alarmDate: Date){
//        if(alarmDate.before(Date())){   //현재 시간보다 이전이면 알람이 없다고 표시
//            infoText.setText("알람이 없습니다.")
//        }
//        else{
//            infoText.setText(dateFormat.format(alarmDate))
//        }
//    }

}