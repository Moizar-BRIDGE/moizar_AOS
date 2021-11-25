package com.example.moizar

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AlarmRecyclewAdater (AlarmActivity: AlarmActivity) : RecyclerView.Adapter<AlarmRecyclewAdater.ViewHolder>() {
    var datas = mutableListOf<Alarmdata>()
    interface OnItemClickListener{
        fun onItemClick(v:View, data: Alarmdata, pos : Int)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.alarm_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])

    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val user_name: TextView = itemView.findViewById(R.id.name)
        private val name_after: TextView = itemView.findViewById(R.id.name_after)
        private val Alarm_detail: TextView = itemView.findViewById(R.id.Alarm_detail)
        private val notifi: ImageView = itemView.findViewById(R.id.notifi)
        private val clear: ImageButton = itemView.findViewById(R.id.clear)

        fun bind(item: Alarmdata) {
            user_name.text = item.name
            name_after.text = item.name_after
            Alarm_detail.text = item.Alarm_detail
            Glide.with(itemView).load(item.notifi).into(notifi)
            Glide.with(itemView).load(item.clear).into(clear)
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