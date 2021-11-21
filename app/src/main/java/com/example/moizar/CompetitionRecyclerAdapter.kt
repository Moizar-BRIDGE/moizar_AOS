package com.example.moizar

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import android.content.ClipData.Item




class CompetitionRecyclerAdapter(val profileList: ProfileList) :
    RecyclerView.Adapter<CompetitionRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CompetitionRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_competition_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompetitionRecyclerAdapter.ViewHolder, position: Int) {

        val lp = holder.itemView.layoutParams
        if (lp is StaggeredGridLayoutManager.LayoutParams) {
            val sglp = lp
//            sglp.isFullSpan = item.isActive
            holder.itemView.layoutParams = sglp
        }
    }

    override fun getItemCount(): Int {
        return profileList.personList.size
    }
}