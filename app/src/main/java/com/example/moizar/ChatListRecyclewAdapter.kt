package com.example.moizar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ChatListRecyclewAdapter(chatListActivity: ChatListActivity) : RecyclerView.Adapter<ChatListRecyclewAdapter.ViewHolder>() {
    
    var datas = mutableListOf<ChatListdata>()
    interface OnItemClickListener{
        fun onItemClick(v:View, data: ChatListdata, pos : Int)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val user_name: TextView = itemView.findViewById(R.id.name)
        private val last_chat_num: TextView = itemView.findViewById(R.id.last_chat_num)
        private val user_image: ImageView = itemView.findViewById(R.id.user_image)
        private val last_chat: TextView = itemView.findViewById(R.id.last_chat)
        private val last_chat_time: TextView = itemView.findViewById(R.id.last_chat_time)

        fun bind(item: ChatListdata) {
            user_name.text = item.name
            last_chat_num.text = item.last_chat_num
            last_chat.text = item.last_chat
            last_chat_time.text = item.last_chat_time
            Glide.with(itemView).load(item.user_image).circleCrop().into(user_image)
            val pos = adapterPosition
            if(pos!= RecyclerView.NO_POSITION)
            {
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView,item,pos)
                }
            }
        }
    }


}