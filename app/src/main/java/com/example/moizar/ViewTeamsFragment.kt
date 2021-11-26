package com.example.moizar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewTeamsFragment : Fragment() {
    private lateinit var teamslistAdapter: TeamsRecyclerAdapter

    private val closeRecipientCardOnBackPressed = object : OnBackPressedCallback(false) {
        var expandedChip: View? = null
        override fun handleOnBackPressed() {
            expandedChip?.let { collapseChip(it) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_view_teams, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inmunList = mutableListOf<String>("기획/아이디어", "광고/마케팅", "취업/창업", "문학/글/시나리오")

        val profileList = createTeamsList()
        teamslistAdapter =
            TeamsRecyclerAdapter(
                teamsList = profileList,
                activity = getActivity()
            )
        val teamsListRecyclerView: RecyclerView = view.findViewById(R.id.teams_recyclerView)
        teamsListRecyclerView.adapter = teamslistAdapter
        teamsListRecyclerView.layoutManager =
            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        val teamsSearchFilter: ImageButton = view.findViewById(R.id.teams_search_filter)
        val filterBtnScrim: View = view.findViewById(R.id.filter_btn_scrim)

        teamsSearchFilter.setOnClickListener {
            view.findViewById<NestedScrollView>(R.id.filter_scrim_view).visibility = View.VISIBLE
            val scrimViewClearBtn: ImageButton = view.findViewById(R.id.scrim_view_clear_btn)
            scrimViewClearBtn.setOnClickListener {
                view.findViewById<NestedScrollView>(R.id.filter_scrim_view).visibility =
                    View.INVISIBLE
                filterBtnScrim.visibility = View.INVISIBLE
            }
            filterBtnScrim.visibility = View.VISIBLE
        }

        filterBtnScrim.setOnClickListener {
            view.findViewById<NestedScrollView>(R.id.filter_scrim_view).visibility = View.INVISIBLE
            filterBtnScrim.visibility = View.INVISIBLE
        }
    }

    private fun collapseChip(chip: View) {
        // Remove the scrim view and on back pressed callbacks
//        view.findViewById<NestedScrollView>(R.id.filter_scrim_view).visibility = View.GONE
        closeRecipientCardOnBackPressed.expandedChip = null
        closeRecipientCardOnBackPressed.isEnabled = false

        // TODO: Set up MaterialContainerTransform beginDelayedTransition.
        chip.visibility = View.VISIBLE
        chip.findViewById<NestedScrollView>(R.id.filter_scrim_view).visibility = View.INVISIBLE
    }
}

fun createTeamsList(
    teamsList: TeamsModel = TeamsModel()
): TeamsModel {
    teamsList.addTeams(
        TeamsDetail(
            tNum = 2,
            cNum = 31,
            teamsTitle = "디자이너르 모집합니다.",
            competitionName = "2021 원티드 해,커리어",
            cateName = "기획/아이디어, 웹/모바일/IT,",
            dDay = "0",
            isBookmarked = false,
            isActive = false,
            viewtype = 1
        )
    )
    //1
    teamsList.addTeams(
        TeamsDetail(
            tNum = 3,
            cNum = 13,
            teamsTitle = "파이썬 전문가 모집합니다.",
            competitionName = "2021 기계독해 데이터셋 학습 알고리즘 개발대회",
            cateName = "기획/아이디어, 웹/모바일/IT, 게임/소프트웨어, 과학",
            dDay = "11",
            isBookmarked = false,
            isActive = false,
            viewtype = 1
        )
    )
//2
    teamsList.addTeams(
        TeamsDetail(
            tNum = 4,
            cNum = 13,
            teamsTitle = "마케팅 기획자,광고분야 전문가 모집합니다.",
            competitionName = "2021 기계독해 데이터셋 학습 알고리즘 개발대회",
            cateName = "광고/마케팅, 영상/UCC/사진, 웹/모바일/IT, 예체능",
            dDay = "26",
            isBookmarked = false,
            isActive = false,
            viewtype = 1
        )
    )
//3
    teamsList.addTeams(
        TeamsDetail(
            tNum = 5,
            cNum = 88,
            teamsTitle = "블록체인 P2P 데이터 하시는분 구합니다.",
            competitionName = "2021 위믹스 블록체인 해커톤",
            cateName = "기타",
            dDay = "29",
            isBookmarked = false,
            isActive = false,
            viewtype = 1
        )
    )
//4
    teamsList.addTeams(
        TeamsDetail(
            tNum = 6,
            cNum = 88,
            teamsTitle = "영상 편집가, 기획자 모집합니다.",
            competitionName = "2021 국제 청소년 평화·휴머니즘 영상공모제",
            cateName = "영상/UCC/사진",
            dDay = "21",
            isBookmarked = false,
            isActive = false,
            viewtype = 1
        )
    )
//5
    teamsList.addTeams(
        TeamsDetail(
            tNum = 7,
            cNum = 88,
            teamsTitle = "java 개발자 모집합니다.",
            competitionName = "2021 기계독해 데이터셋 학습 알고리즘 개발대회",
            cateName = "기획/아이디어, 웹/모바일/IT, 게임/소프트웨어, 과학",
            dDay = "22",
            isBookmarked = false,
            isActive = false,
            viewtype = 1
        )
    )
//6
    teamsList.addTeams(
        TeamsDetail(
            tNum = 8,
            cNum = 88,
            teamsTitle = "영상 편집가 모집합니다.",
            competitionName = "2021 기계독해 데이터셋 학습 알고리즘 개발대회",
            cateName = "기획/아이디어, 웹/모바일/IT, 게임/소프트웨어, 과학",
            dDay = "14",
            isBookmarked = false,
            isActive = false,
            viewtype = 1
        )
    )



    return teamsList
}

fun createFakeProfileList1(
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