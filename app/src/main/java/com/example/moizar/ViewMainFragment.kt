package com.example.moizar

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

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
        competition_recycler_view.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        competition_recycler_view.itemAnimator = DefaultItemAnimator()
        competition_recycler_view.adapter = listAdapter2

        val mainScrollView : NestedScrollView = view.findViewById(R.id.main_scrollView)
        OverScrollDecoratorHelper.setUpOverScroll(profileList_recycler_view, OverScrollDecoratorHelper.ORIENTATION_HORIZONTAL)
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
    profileList.addPerson(
        ProfileDetail(
            name = "" + "강석원",
            part = "" + "분야",
            school = "" + "공학대학교",
            major = "" + "컴퓨터공학과",
            isActive = true,
            viewtype = 0
        )
    )
    for (i in 1 until fakeNumber) {
        profileList.addPerson(
            ProfileDetail(
                name = "" + i + "강석원",
                part = "" + i + "분야",
                school = "" + i + "공학대학교",
                major = "" + i + "컴퓨터공학과",
                isActive = false,
                viewtype = 1
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

class ProfileDetail(
    val name: String,
    val part: String,
    val school: String,
    val major: String,
    val isActive: Boolean,
    val viewtype: Int
)