package com.example.moizar

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

class ViewMainFragment : Fragment(), View.OnClickListener {

    private lateinit var listAdapter: ProfileRecyclerAdapter
    private lateinit var listAdapter2: CompetitionRecyclerAdapter

    private val fragmentViewTeams by lazy { ViewTeamsFragment() }
    private val fragmentViewPeoples by lazy { ViewPeoplesFragment() }
    private val fragmentViewCompetition by lazy { ViewCompetitionFragment() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_view_main, container, false)

        // 탭 전환 버튼 부분
        val swipeTeamsTabBtn: MainTeamsBtnView = view.findViewById(R.id.swipe_teams_tab_btn)
        val swipeProfileTabBtn: TextView = view.findViewById(R.id.swipe_profile_tab_btn)
        val swipeCompetitionTabBtn: TextView = view.findViewById(R.id.swipe_competitions_tab_btn)

        swipeTeamsTabBtn.setOnClickListener(this)
        swipeProfileTabBtn.setOnClickListener(this)
        swipeCompetitionTabBtn.setOnClickListener(this)

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

        val mainScrollView: NestedScrollView = view.findViewById(R.id.main_scrollView)
        OverScrollDecoratorHelper.setUpOverScroll(
            profileList_recycler_view,
            OverScrollDecoratorHelper.ORIENTATION_HORIZONTAL
        )

    }


    override fun onClick(v: View?) {
        val teamsWriteBtn: FloatingActionButton =
            requireActivity().findViewById(R.id.teams_write_btn)
        val customBottomNavigationView1: CustomBottomNavigationView1 =
            requireActivity().findViewById(R.id.customBottomBar)
        val intent = Intent(activity, TeamsWriteActivity::class.java)

        when (v?.id) {
            R.id.swipe_teams_tab_btn -> {
                changeFragment(fragmentViewTeams)
                teamsWriteBtn.visibility = View.VISIBLE
                teamsWriteBtn.setOnClickListener {
                    startActivity(intent)
                }
                customBottomNavigationView1.menu.findItem(R.id.action_main).isChecked = false
                customBottomNavigationView1.menu.findItem(R.id.action_teams).isChecked = true
            }
            R.id.swipe_profile_tab_btn -> {
                changeFragment(fragmentViewPeoples)
                teamsWriteBtn.visibility = View.INVISIBLE
                customBottomNavigationView1.menu.findItem(R.id.action_main).isChecked = false
                customBottomNavigationView1.menu.findItem(R.id.action_peoples).isChecked = true
            }
            R.id.swipe_competitions_tab_btn -> {
                changeFragment(fragmentViewCompetition)
                teamsWriteBtn.visibility = View.INVISIBLE
                customBottomNavigationView1.menu.findItem(R.id.action_main).isChecked = false
                customBottomNavigationView1.menu.findItem(R.id.action_competition).isChecked = true
            }
            else -> {
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        val fragManager: FragmentManager = requireActivity().getSupportFragmentManager()
        fragManager.beginTransaction().replace(R.id.view_Pager, fragment).commit()
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