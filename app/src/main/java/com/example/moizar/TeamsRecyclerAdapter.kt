package com.example.moizar

import android.animation.ValueAnimator
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import org.w3c.dom.Text

class TeamsRecyclerAdapter(
    val teamsList: TeamsModel,
    val activity: FragmentActivity?
) : RecyclerView.Adapter<TeamsRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val competitionTag: TextView
        val competitionDDay: TextView
        val competitionName: TextView
        val teamsTitle: TextView

        init {
            competitionTag = itemView.findViewById(R.id.competition_tag)
            competitionDDay = itemView.findViewById(R.id.competition_dDay)
            competitionName = itemView.findViewById(R.id.competition_name)
            teamsTitle = itemView.findViewById(R.id.teams_title)

            itemView.setOnClickListener {
                val teamsDetailIntent = Intent(activity, TeamsDetailActivity::class.java)
                activity!!.startActivity(teamsDetailIntent)
            }
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
        holder.competitionTag.setText(teamsList.teamsList.get(position).cateName)
        holder.competitionDDay.setText("D-" + teamsList.teamsList.get(position).dDay)
        holder.competitionName.setText(teamsList.teamsList.get(position).competitionName)
        holder.teamsTitle.setText(teamsList.teamsList.get(position).teamsTitle)
    }

    override fun getItemCount(): Int {
        return teamsList.teamsList.size
    }
}