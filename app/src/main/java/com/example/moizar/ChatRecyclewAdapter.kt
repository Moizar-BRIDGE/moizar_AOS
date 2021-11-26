package com.example.moizar

import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ChatRecyclewAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas = mutableListOf<ChatModelData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        val view : View?
        return when(viewType) {
            multi_type1 -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.chat_your_item,
                    parent,
                    false
                )
                MultiViewHolder1(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.chat_myitem,
                    parent,
                    false
                )
                MultiViewHolder2(view)
            }
        }

    }
    override fun getItemCount(): Int = datas.size

    override fun getItemViewType(position: Int): Int {
        return datas[position].type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(datas[position].type) {
            multi_type1 -> {
                (holder as MultiViewHolder1).bind(datas[position])
                holder.setIsRecyclable(false)
            }
            else -> {
                (holder as MultiViewHolder2).bind(datas[position])
                holder.setIsRecyclable(false)
            }
        }
    }

    inner class MultiViewHolder1(view: View) : RecyclerView.ViewHolder(view) {

        private val txtName: TextView = view.findViewById(R.id.messageItem_textview_name)
        private val chat: TextView = view.findViewById(R.id.messageItem_textView_message)
        private val imgProfile: ImageView = view.findViewById(R.id.messageItem_imageview_profile)
        private val time: TextView = view.findViewById(R.id.messageItem_textView_time)

        fun bind(item: ChatModelData) {
            txtName.text = item.name
            chat.text = item.chat
            time.text = item.time
            Glide.with(itemView).load(item.image).into(imgProfile)

        }
    }
    inner class MultiViewHolder2(view: View) : RecyclerView.ViewHolder(view) {

        private val chat: TextView = view.findViewById(R.id.messageItem_textView_message)
        private val time: TextView = view.findViewById(R.id.messageItem_textView_time)

        fun bind(item: ChatModelData) {
                chat.text = item.chat
                time.text = item.time
        }
    }
}