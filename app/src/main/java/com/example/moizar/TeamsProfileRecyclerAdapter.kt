package com.example.moizar

import android.animation.ValueAnimator
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

 class TeamsProfileRecyclerAdapter(
    val profileList: TeamsProfile,
    val inflater: LayoutInflater,
    val activity: Activity
) : RecyclerView.Adapter<TeamsProfileRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView
        val teamsLeaderCheck : TextView

        init {
            personName = itemView.findViewById(R.id.user_name)
            teamsLeaderCheck = itemView.findViewById(R.id.teams_leader_check)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.column_teams_profile_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(profileList.personList.get(position).name)
        holder.teamsLeaderCheck.isVisible = profileList.personList.get(position).leader
    }

    override fun getItemCount(): Int {
        return profileList.personList.size
    }
}