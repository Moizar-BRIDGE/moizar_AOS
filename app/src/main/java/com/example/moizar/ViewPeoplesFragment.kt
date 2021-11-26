package com.example.moizar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ViewPeoplesFragment : Fragment() {

    private lateinit var listAdapter: ProfileRecyclerAdapter2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_view_peoples, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //        프로필 보기 RecyclerView 생성 부분
        val profileList = createProfileList()
        listAdapter =
            ProfileRecyclerAdapter2(
                profileList = profileList,
                activity = getActivity()
            )

        val profileList_recycler_view: RecyclerView =
            view.findViewById(R.id.profile_recyclerView)
        profileList_recycler_view.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        profileList_recycler_view.itemAnimator = DefaultItemAnimator()
        profileList_recycler_view.addItemDecoration(RecyclerViewDecoration(10))
        profileList_recycler_view.adapter = listAdapter
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
//class ProfileList() {
//    // 가짜 프로필 정보
//    val personList = ArrayList<ProfileDetail>()
//
//    fun addPerson(person: ProfileDetail) {
//        personList.add(person)
//    }
//}
//
//class ProfileDetail(
//    val name: String,
//    val part: String,
//    val school: String,
//    val major: String,
//    val isActive: Boolean,
//    val viewtype: Int
//)