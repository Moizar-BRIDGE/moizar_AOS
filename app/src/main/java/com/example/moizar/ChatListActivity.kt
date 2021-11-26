package com.example.moizar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView

class ChatListActivity : AppCompatActivity() {
    lateinit var profileAdapter: ChatListRecyclewAdapter
    private lateinit var chat_list : RecyclerView
    private lateinit var alarm : ImageButton
    val datas = mutableListOf<ChatListdata>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatlist)
        chat_list = findViewById(R.id.chat_list)
        alarm = findViewById(R.id.notification_ic)
        alarm.setOnClickListener {
            val intent = Intent(this, AlarmActivity::class.java)
            startActivity(intent)
            finish()
        }
        initRecycler()
    }
    private fun initRecycler() {
        profileAdapter = ChatListRecyclewAdapter(this)
        chat_list.adapter = profileAdapter


        datas.apply {
            add(ChatListdata(user_image = R.drawable.ic_moizar_logo, name = "조재원", last_chat_num = "1", last_chat = "앞으로 잘부탁드립니다~!", last_chat_time = "10:36 PM"))
            add(ChatListdata(user_image = R.drawable.ic_moizar_logo, name = "강석원", last_chat_num = "4", last_chat = "맡겨만주세요. 제 실력 상당합니다.", last_chat_time = "1일"))
            add(ChatListdata(user_image = R.drawable.ic_moizar_logo, name = "김예림", last_chat_num = "6", last_chat = "제가 그런부분까지 해야하나요?", last_chat_time = "7일"))
            add(ChatListdata(user_image = R.drawable.ic_moizar_logo, name = "오래영", last_chat_num = "21", last_chat = "네. 다음 모임장소에서 뵐게요.", last_chat_time = "9월 23일"))
            profileAdapter.setOnItemClickListener(object : ChatListRecyclewAdapter.OnItemClickListener{
                override fun onItemClick(v: View, data: ChatListdata, pos: Int) {
                    val intent = Intent(this@ChatListActivity, ChatActivity::class.java).apply{
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