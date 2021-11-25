package com.example.moizar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class AlarmActivity : AppCompatActivity() {
    lateinit var profileAdapter: AlarmRecyclewAdater
    private lateinit var alarm_list : RecyclerView
    val datas = mutableListOf<Alarmdata>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        alarm_list = findViewById(R.id.alarm_list)
        profileAdapter = AlarmRecyclewAdater(this)
        initRecycler()
    }
    private fun initRecycler() {

        alarm_list.adapter = profileAdapter

        datas.apply {
            add(Alarmdata(name = "조재원", name_after = "님으로부터 온 초대 알림입니다.", Alarm_detail = "2021년 초기창업패키지 온라인 창업 프로젝트 개발자로 모시고싶습니다.",notifi = R.drawable.ic_notification2,
                clear = R.drawable.ic_clear))
            add(Alarmdata(name = "김예림", name_after = "님으로부터 온 초대 알림입니다.", Alarm_detail = "2021년 공공 데이터 공모전 영상 편집가 지원을 희망합니다" ,notifi = R.drawable.ic_notification2,
                clear = R.drawable.ic_clear))
            add(Alarmdata(name = "강석원", name_after = "님으로부터 온 초대 알림입니다.", Alarm_detail = "2021년 해커리어 안드로이드 개발자로 모시고싶습니다." ,notifi = R.drawable.ic_notification2,
                clear = R.drawable.ic_clear))
            profileAdapter.setOnItemClickListener(object : AlarmRecyclewAdater.OnItemClickListener{
                override fun onItemClick(v: View, data: Alarmdata, pos : Int) {
                    val intent = Intent(this@AlarmActivity, AlarmDatail::class.java).apply{
                        putExtra("data", data.name)
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }.run{ startActivity(this)
                    }
                }
            })

            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()

        }
    }
}