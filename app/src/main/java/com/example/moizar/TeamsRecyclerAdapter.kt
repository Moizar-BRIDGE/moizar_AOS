package com.example.moizar

import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

class TeamsRecyclerAdapter(
    val profileList: ProfileList,
) : RecyclerView.Adapter<TeamsRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView

        init {
            personName = itemView.findViewById(R.id.competition_tag)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_teams_item, parent, false)

//        var isLiked: Boolean = false
//        // 좋아요 버튼 리스너 장착
//        val like_btn: LottieAnimationView = view.findViewById(R.id.like_btn)
//        like_btn.setOnClickListener {
//
//            if (isLiked == false) {
//                // Custom animation speed or duration.
//                val animator = ValueAnimator.ofFloat(0f, 0.5f).setDuration(1000)
//                animator.addUpdateListener {
//                    like_btn.setProgress(
//                        animator.getAnimatedValue() as Float
//                    )
//                }
//                animator.start()
//                isLiked = true
//            } else {
//                // Custom animation speed or duration.
//                val animator = ValueAnimator.ofFloat(0.5f, 1f).setDuration(300)
//                animator.addUpdateListener {
//                    like_btn.setProgress(
//                        animator.getAnimatedValue() as Float
//                    )
//                }
//                animator.start()
//                isLiked = false
//            }
//        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(profileList.personList.get(position).name)
    }

    override fun getItemCount(): Int {
        return profileList.personList.size
    }
}