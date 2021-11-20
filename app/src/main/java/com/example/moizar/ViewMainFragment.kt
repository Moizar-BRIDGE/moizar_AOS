package com.example.moizar

import android.animation.ValueAnimator
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

class ViewMainFragment : Fragment(), View.OnClickListener {

    private lateinit var listAdapter: ProfileListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_view_main, container, false)

        // Inflate the layout for this fragment
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val profileList = createFakeProfileList(fakeNumber = 30)
        listAdapter =
            ProfileListRecyclerAdapter(
                profileList = profileList
            )

        val profileList_recycler_view: RecyclerView =
            view.findViewById(R.id.profile_recycler_view)
        profileList_recycler_view.adapter = listAdapter
        profileList_recycler_view.layoutManager =
            LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.like_btn -> {
                Log.d("btn", "눌림")
            }
            else -> {

            }
        }
    }

}

fun createFakeProfileList(
    fakeNumber: Int = 10,
    profileList: ProfileList = ProfileList()
): ProfileList {
    for (i in 0 until fakeNumber) {
        profileList.addPerson(
            ProfileDetail(
                name = "" + i + "사람",
                part = "" + i + "분야",
                school = "" + i + "공학대학교",
                major = "" + i + "컴퓨터공학과",
            )
        )
    }
    return profileList
}


//// 서버 연동하고 아래 삭제할거임
//// 가짜 데이터임
class ProfileListRecyclerAdapter(
    val profileList: ProfileList,
) : RecyclerView.Adapter<ProfileListRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView

        init {
            personName = itemView.findViewById(R.id.user_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_item, parent, false)

        var isLiked: Boolean = false

        // 좋아요 버튼 리스너 장착
        val like_btn: LottieAnimationView = view.findViewById(R.id.like_btn)
        like_btn.setOnClickListener {

            if(isLiked == false){
                // Custom animation speed or duration.
                val animator = ValueAnimator.ofFloat(0f, 0.5f).setDuration(1000)
                animator.addUpdateListener {
                    like_btn.setProgress(
                        animator.getAnimatedValue() as Float
                    )
                }
                animator.start()
                isLiked = true
            } else{
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
        holder.personName.setText(profileList.personList.get(position).name)
    }

    override fun getItemCount(): Int {
        return profileList.personList.size
    }
}

////class 생성
class ProfileList() {
    // 가짜 프로필 정보
    val personList = ArrayList<ProfileDetail>()

    fun addPerson(person: ProfileDetail) {
        personList.add(person)
    }
}

class ProfileDetail(val name: String, val part: String, val school: String, val major: String) {

}