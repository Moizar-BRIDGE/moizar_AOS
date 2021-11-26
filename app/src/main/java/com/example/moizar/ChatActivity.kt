package com.example.moizar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.parser.IntegerParser
import java.text.SimpleDateFormat
import java.util.*

class ChatActivity : AppCompatActivity() {
    lateinit var profileAdapter: ChatRecyclewAdapter
    private var textnum : Int = 0
    private lateinit var chat_list : RecyclerView
    private lateinit var chat_edit : EditText
    private lateinit var back_btn : ImageButton
    private lateinit var chat_edit_String : String
    private lateinit var send_btn : AppCompatButton
    val datas = mutableListOf<ChatModelData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        chat_list = findViewById(R.id.messageActivity_recyclerview)
        chat_edit = findViewById(R.id.messageActivity_editText)
        send_btn = findViewById(R.id.send_btn)
        back_btn = findViewById(R.id.back_btn)
        back_btn.setOnClickListener {
            val intent = Intent(this, ChatListActivity::class.java)
            startActivity(intent)
            finish()
        }
        edit_set()
        initRecycler()
            send_btn.setOnClickListener {
                Edit_initRecycler()
            }
    }
    private fun Edit_initRecycler() {
        val now: Long = System.currentTimeMillis()
        val date = Date(now)
        val dateFormat = SimpleDateFormat("HH:mm", Locale("ko", "KR"))
        var stringTime = dateFormat.format(date)
        val ampmtime = stringTime.split(":")
        stringTime = time(ampmtime)
        profileAdapter = ChatRecyclewAdapter(this)
        chat_edit_String = chat_edit.text.toString()
        chat_list.adapter = profileAdapter
        datas.apply {
            add(ChatModelData(chat = chat_edit_String,image = R.drawable.img_profile_test, name = "김예림", time = stringTime, type = multi_type2))
            profileAdapter.datas = datas
            }
            profileAdapter.notifyDataSetChanged()
            chat_edit.text = null
            send_btn.visibility = View.INVISIBLE

    }
    private fun initRecycler() {
        profileAdapter = ChatRecyclewAdapter(this)
        chat_list.adapter = profileAdapter
            datas.apply {
                add(ChatModelData(chat = "앞으로 잘 부탁 드립니다~!",image = R.drawable.ic_moizar_logo, name = "김예림", time = "10:36 PM", type = multi_type1))
                profileAdapter.datas = datas
                profileAdapter.notifyDataSetChanged()
        }
    }
    private fun time(time : List<String>): String {
        var result : String
        var num : Int
        if(time[0].toInt() >= 12){
            num = time[0].toInt() - 12
            result = num.toString() + ":"+ time[1] + " PM"
        }
        else{
            result = time[0] + ":"+ time[1] + " AM"
        }
        return result
    }
    private fun edit_set() {
        chat_edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                textnum = p0!!.length
                if(textnum != 0)
                {
                    send_btn.visibility = View.VISIBLE
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }
}