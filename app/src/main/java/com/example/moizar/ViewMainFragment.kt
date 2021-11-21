package com.example.moizar

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ViewMainFragment : Fragment(), View.OnClickListener {

    private lateinit var listAdapter: ProfileRecyclerAdapter
    private lateinit var listAdapter2: CompetitionRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_view_main, container, false)
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        프로필 둘러보기 RecyclerView 생성 부분
        val profileList = createFakeProfileList(fakeNumber = 5)
        listAdapter =
            ProfileRecyclerAdapter(
                profileList = profileList
            )
        listAdapter2 =
            CompetitionRecyclerAdapter(
                profileList = profileList
            )

        val profileList_recycler_view: RecyclerView =
            view.findViewById(R.id.profile_recycler_view)
        profileList_recycler_view.adapter = listAdapter
        profileList_recycler_view.layoutManager =
            LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)

        // 공모전 모음
        val competition_recycler_view: RecyclerView =
            view.findViewById(R.id.competition_recycler_view)
        competition_recycler_view.adapter = listAdapter2
        competition_recycler_view.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
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
                name = "" + i + "강석원",
                part = "" + i + "분야",
                school = "" + i + "공학대학교",
                major = "" + i + "컴퓨터공학과",
            )
        )
    }
    return profileList
}

////삭제할거임
// class 생성
class ProfileList() {
    // 가짜 프로필 정보
    val personList = ArrayList<ProfileDetail>()

    fun addPerson(person: ProfileDetail) {
        personList.add(person)
    }
}

class ProfileDetail(val name: String, val part: String, val school: String, val major: String) {

}