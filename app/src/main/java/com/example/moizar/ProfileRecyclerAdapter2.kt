package com.example.moizar

import android.animation.ValueAnimator
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class ProfileRecyclerAdapter2(
    val profileList: ProfileModel,
    val activity: FragmentActivity?
) : RecyclerView.Adapter<ProfileRecyclerAdapter2.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView
        val likeBtn: LottieAnimationView
        val cardSubtitle2: TextView
        val schoolName: TextView
        val majorName: TextView
        val imageView: CircleImageView

        init {
            personName = itemView.findViewById(R.id.user_name)
            likeBtn = itemView.findViewById(R.id.like_btn)
            cardSubtitle2 = itemView.findViewById(R.id.card_subtitle2)
            schoolName = itemView.findViewById(R.id.school_name)
            majorName = itemView.findViewById(R.id.major_name)
            imageView = itemView.findViewById(R.id.imageView)

            itemView.setOnClickListener {
                val profileDetailIntent = Intent(activity, ProfileDetailActivity::class.java)
                activity!!.startActivity(profileDetailIntent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.column_profile_item2, parent, false)

        var isLiked: Boolean = false

        // 좋아요 버튼 리스너 장착
        val like_btn: LottieAnimationView = view.findViewById(R.id.like_btn)
        like_btn.setOnClickListener {

            if (isLiked == false) {
                // Custom animation speed or duration.
                val animator = ValueAnimator.ofFloat(0f, 0.5f).setDuration(1000)
                animator.addUpdateListener {
                    like_btn.setProgress(
                        animator.getAnimatedValue() as Float
                    )
                }
                animator.start()
                isLiked = true
            } else {
                // Custom animation speed or duration.
                val animator = ValueAnimator.ofFloat(0.5f, 1f).setDuration(300)
                animator.addUpdateListener {
                    like_btn.setProgress(
                        animator.getAnimatedValue() as Float
                    )
                }
                animator.start()
                isLiked = false
            }


        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(profileList.profileList.get(position).name)
        holder.cardSubtitle2.setText(profileList.profileList.get(position).part)
        holder.schoolName.setText(profileList.profileList.get(position).school)
        holder.majorName.setText(profileList.profileList.get(position).major)
        Glide.with(holder.itemView.context).load(profileList.profileList.get(position).image)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return profileList.profileList.size
    }
}