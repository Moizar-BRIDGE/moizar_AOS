package com.example.moizar

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import android.content.ClipData.Item
import android.util.Log
import java.lang.RuntimeException

class CompetitionRecyclerAdapter(val profileList: ProfileList) :
    RecyclerView.Adapter<CompetitionRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CompetitionRecyclerAdapter.ViewHolder {
        val view1 = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_competition_item, parent, false)
        val view2 = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_competition_item2, parent, false)

        when (viewType) {
            0 -> {
                return ViewHolder(view1)
            }
            1 -> {
                return ViewHolder(view2)
            }
            else -> throw RuntimeException("ViewTypeError")
        }

//        if(profileList.personList.get(viewType).isActive == true ){
//            return ViewHolder(view2)
//        }else {
//            return ViewHolder(view1)
//        }


    }

    override fun getItemViewType(position: Int): Int {
        return profileList.personList.get(position).viewtype
    }

    override fun onBindViewHolder(holder: CompetitionRecyclerAdapter.ViewHolder, position: Int) {

        // 공모전 모아보기에서 0번째 요소는 fullspan으로 처리하고 나머지는 하나의 행에 2개씩 표시한다.
        val lp = holder.itemView.layoutParams
        if (lp is StaggeredGridLayoutManager.LayoutParams) {
            val sglp = lp
            sglp.isFullSpan = profileList.personList.get(position).isActive
            holder.itemView.layoutParams = sglp
        }

    }

    override fun getItemCount(): Int {
        return profileList.personList.size
    }
}