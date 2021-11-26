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
import kotlinx.coroutines.NonCancellable.isActive
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
        val profileModel = createProfileList()
        listAdapter =
            ProfileRecyclerAdapter(
                profileList = profileModel
            )
        val competitionModel = createCompetitionList()
        listAdapter2 =
            CompetitionRecyclerAdapter(
                competitionList = competitionModel
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

fun createProfileList(
    profileModel: ProfileModel = ProfileModel()
): ProfileModel {
    profileModel.addPerson(
        ProfileViewDetail(
            uid = "gi6nXv8FwgPNnjQQku11fZbAUn23",
            name = "오래영",
            image = "https://moizaimage.s3.ap-northeast-2.amazonaws.com/KakaoTalk_20211125_234140400_02.jpg",
            email = "nwj20315@gmail.com",
            major = "컴퓨터공학",
            part = "백엔드 개발",
            school = "한국공학대학교",
            resume = "백엔드 분야로 공모전에 나가고 싶은  컴퓨터공학 4학년입니다.",
            experience = "프로보노 프로젝트 참여, AR 앱 개발",
            isLiked = false
        )
    )
    profileModel.addPerson(
        ProfileViewDetail(
            uid = "jRBzpwPd6KcU0yHEXiCp43CXGVv1",
            name = "강석원",
            image = "https://moizaimage.s3.ap-northeast-2.amazonaws.com/KakaoTalk_20211125_234140400_01.jpg",
            email = "rkdtjrdnjs1@gmail.com",
            major = "컴퓨터공학",
            part = "안드로이드 개발",
            school = "한국공학대학교",
            resume = "컴퓨터공학을 전공하였으며 안드로이드에 관심이 많은 4학년입니다.",
            experience = "프로보노 프로젝트 참여, AR 앱 개발",
            isLiked = true
        )
    )
    profileModel.addPerson(
        ProfileViewDetail(
            uid = "OiRLpqjWfxQMPN8cd5zHjI4b8ZV2",
            name = "조재원",
            image = "https://moizaimage.s3.ap-northeast-2.amazonaws.com/default.png",
            email = "m970314@naver.com",
            major = "경영학",
            part = "서비스 기획",
            school = "한국공학대학교",
            resume = "경영 전공이며, 서비스, 사업개발 및 운영 기획을 맡을 수 있습니다.",
            experience = "공모전 수상 경력 2회",
            isLiked = true
        )
    )
    profileModel.addPerson(
        ProfileViewDetail(
            uid = "OiRLpqjWfxQMPN8cd5zHjI4b8ZV2",
            name = "김예림",
            image = "https://moizaimage.s3.ap-northeast-2.amazonaws.com/KakaoTalk_20211125_234140400.jpg",
            email = "m970314@naver.com",
            major = "경영학",
            part = "UI/UX 디자인",
            school = "한국공학대학교",
            resume = "경영 전공이며, 서비스, 사업개발 및 운영 기획을 맡을 수 있습니다.",
            experience = "공모전 수상 경력 2회",
            isLiked = false
        )
    )
    profileModel.addPerson(
        ProfileViewDetail(
            uid = "OiRLpqjWfxQMPN8cd5zHjI4b8ZV2",
            name = "박윤찬",
            image = "https://moizaimage.s3.ap-northeast-2.amazonaws.com/default.png",
            email = "m970314@naver.com",
            major = "컴퓨터공학",
            part = "웹 프론트엔드",
            school = "한국공학대학교",
            resume = "경영 전공이며, 서비스, 사업개발 및 운영 기획을 맡을 수 있습니다.",
            experience = "공모전 수상 경력 2회",
            isLiked = false
        )
    )
    profileModel.addPerson(
        ProfileViewDetail(
            uid = "OiRLpqjWfxQMPN8cd5zHjI4b8ZV2",
            name = "박상수",
            image = "https://moizaimage.s3.ap-northeast-2.amazonaws.com/default.png",
            email = "m970314@naver.com",
            major = "경영학",
            part = "서비스 기획",
            school = "한국공학대학교",
            resume = "경영 전공이며, 서비스, 사업개발 및 운영 기획을 맡을 수 있습니다.",
            experience = "공모전 수상 경력 2회",
            isLiked = false
        )
    )
    profileModel.addPerson(
        ProfileViewDetail(
            uid = "OiRLpqjWfxQMPN8cd5zHjI4b8ZV2",
            name = "김민규",
            image = "https://moizaimage.s3.ap-northeast-2.amazonaws.com/default.png",
            email = "m970314@naver.com",
            major = "경영학",
            part = "서비스 기획",
            school = "한국공학대학교",
            resume = "경영 전공이며, 서비스, 사업개발 및 운영 기획을 맡을 수 있습니다.",
            experience = "공모전 수상 경력 2회",
            isLiked = true
        )
    )
    profileModel.addPerson(
        ProfileViewDetail(
            uid = "OiRLpqjWfxQMPN8cd5zHjI4b8ZV2",
            name = "이승진",
            image = "https://moizaimage.s3.ap-northeast-2.amazonaws.com/default.png",
            email = "m970314@naver.com",
            major = "경영학",
            part = "서비스 기획",
            school = "한국공학대학교",
            resume = "경영 전공이며, 서비스, 사업개발 및 운영 기획을 맡을 수 있습니다.",
            experience = "공모전 수상 경력 2회",
            isLiked = true
        )
    )
    profileModel.addPerson(
        ProfileViewDetail(
            uid = "OiRLpqjWfxQMPN8cd5zHjI4b8ZV2",
            name = "강소연",
            image = "https://moizaimage.s3.ap-northeast-2.amazonaws.com/default.png",
            email = "m970314@naver.com",
            major = "경영학",
            part = "서비스 기획",
            school = "한국공학대학교",
            resume = "경영 전공이며, 서비스, 사업개발 및 운영 기획을 맡을 수 있습니다.",
            experience = "공모전 수상 경력 2회",
            isLiked = true
        )
    )

    return profileModel
}


fun createCompetitionList(
    competitionModel: CompetitionModel = CompetitionModel()
): CompetitionModel {
    competitionModel.addCompetition(
        CompetitionDetail(
            cNum = 11,
            name = "하나투어 플래너 공모전",
            image = "https://www.wevity.com/upload/contest/20211124032244_37c8c4c2.jpg",
            dDay = "28",
            cateName = "광고/마케팅",
            isActive = true,
            viewtype = 0
        )
    )
    //1
    competitionModel.addCompetition(
        CompetitionDetail(
            cNum = 12,
            name = "LG디스플레이 대학생 인플루언서 디플 23기 모집",
            image = "https://www.wevity.com/upload/contest/20211123091048_2e370062.png",
            dDay = "30",
            cateName = "디자인/캐릭터/웹툰",
            isActive = false,
            viewtype = 1
        )
    )

//2
    competitionModel.addCompetition(
        CompetitionDetail(
            cNum = 13,
            name = "2021 기계독해 데이터셋 학습 알고리즘 개발대회",
            image = "https://www.wevity.com/upload/contest/20211122182630_38867629.jpg",
            dDay = "14",
            cateName = "웹/모바일/IT",
            isActive = false,
            viewtype = 1
        )
    )
//3
    competitionModel.addCompetition(
        CompetitionDetail(
            cNum = 15,
            name = "ifland 이프랜드 메타버스 크리에이터 챌린지",
            image = "https://www.wevity.com/upload/contest/20211119190536_572cdd73.jpg",
            dDay = "10",
            cateName = "영상/UCC/사진",
            isActive = false,
            viewtype = 1
        )
    )
//4
    competitionModel.addCompetition(
        CompetitionDetail(
            cNum = 14,
            name = "LG화학 청소년 환경지킴이 2기 모집",
            image = "https://www.wevity.com/upload/contest/20211122152752_1d10483d.jpg",
            dDay = "14",
            cateName = "과학/공학",
            isActive = false,
            viewtype = 1
        )
    )

    return competitionModel
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