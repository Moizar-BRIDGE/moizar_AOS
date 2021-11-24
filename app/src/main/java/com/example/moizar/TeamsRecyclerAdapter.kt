package com.example.moizar

import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
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
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_teams_item, parent, false)

        var isBookmarked: Boolean = false

        val row_item_constraint: ConstraintLayout = view.findViewById(R.id.row_item_constraint)

//        // 북마크 버튼 리스너 장착
        val bookMark_btn: LottieAnimationView = view.findViewById(R.id.bookMark_btn)
        bookMark_btn.setOnClickListener {

            if (isBookmarked == false) {
                // Custom animation speed or duration.
                val animator = ValueAnimator.ofFloat(0f, 1f).setDuration(1000)
                animator.addUpdateListener {
                    bookMark_btn.setProgress(
                        animator.getAnimatedValue() as Float
                    )
                }
                animator.start()
                isBookmarked = true
                row_item_constraint.setBackgroundResource(R.drawable.btn_teams_bookmark_check)

            } else {
                // Custom animation speed or duration.
                val animator = ValueAnimator.ofFloat(1f, 0f).setDuration(400)
                animator.addUpdateListener {
                    bookMark_btn.setProgress(
                        animator.getAnimatedValue() as Float
                    )
                }
                animator.start()
                isBookmarked = false
                row_item_constraint.setBackgroundResource(R.drawable.btn_teams_bookmark_noncheck)
            }
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(profileList.personList.get(position).name)
    }

    override fun getItemCount(): Int {
        return profileList.personList.size
    }
}