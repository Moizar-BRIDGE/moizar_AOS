package com.example.moizar

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import android.content.ClipData.Item
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import java.lang.RuntimeException

class CompetitionRecyclerAdapter(val competitionList: CompetitionModel) :
    RecyclerView.Adapter<CompetitionRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val competitionImgView: ImageView
        val cardSubtitle2: TextView
        val competitionContent: TextView
        val competitionCategory: TextView

        init {
            competitionImgView = itemView.findViewById(R.id.competition_img_view)
            cardSubtitle2 = itemView.findViewById(R.id.card_subtitle2)
            competitionContent = itemView.findViewById(R.id.competition_content)
            competitionCategory = itemView.findViewById(R.id.competition_category)

        }
    }

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
        return competitionList.competitionList.get(position).viewtype
    }

    override fun onBindViewHolder(holder: CompetitionRecyclerAdapter.ViewHolder, position: Int) {

        // 공모전 모아보기에서 0번째 요소는 fullspan으로 처리하고 나머지는 하나의 행에 2개씩 표시한다.
        val lp = holder.itemView.layoutParams
        if (lp is StaggeredGridLayoutManager.LayoutParams) {
            val sglp = lp
            sglp.isFullSpan = competitionList.competitionList.get(position).isActive
            holder.itemView.layoutParams = sglp
        }

        Glide.with(holder.itemView.context)
            .load(competitionList.competitionList.get(position).image)
            .into(holder.competitionImgView)
        holder.cardSubtitle2.setText("D-" + competitionList.competitionList.get(position).dDay)
        holder.competitionContent.setText(competitionList.competitionList.get(position).name)
        holder.competitionCategory.setText(competitionList.competitionList.get(position).cateName)

    }

    override fun getItemCount(): Int {
        return competitionList.competitionList.size
    }
}