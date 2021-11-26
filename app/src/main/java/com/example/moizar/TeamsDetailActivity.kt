package com.example.moizar

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TeamsDetailActivity : AppCompatActivity() {
    private lateinit var listAdapter: TeamsProfileRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams_detail)

        val detailBackBtn: ImageButton = findViewById(R.id.detail_back_btn)

        detailBackBtn.setOnClickListener {
            finish()
        }

        val teamsWriteBtn: Button = findViewById(R.id.teams_write_btn)
        val teamsApplyIntent = Intent(this, TeamsDetailApplyActivity::class.java)
        teamsWriteBtn.setOnClickListener {
            startActivity(teamsApplyIntent)
        }

        //        프로필 둘러보기 RecyclerView 생성 부분
        val profileList = createFakeTeamsProfileList(fakeNumber = 3)

        listAdapter =
            TeamsProfileRecyclerAdapter(
                profileList = profileList,
                inflater = LayoutInflater.from(this),
                activity = this
            )

        val teamsProfileRecyclerView: RecyclerView =
            findViewById(R.id.teams_profile_recycler_view)
        teamsProfileRecyclerView.adapter = listAdapter
        teamsProfileRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

    }

    fun createFakeTeamsProfileList(
        fakeNumber: Int = 10,
        phoneBook: TeamsProfile = TeamsProfile()
    ): TeamsProfile {
        phoneBook.addPerson(
            TeamsProfileDetail(
                name = "강석원",
                part = "안드로이드 개발",
                college = "한국대학교",
                major = "컴퓨터공학과",
                leader = true
            )
        )

        for (i in 1 until fakeNumber) {
            phoneBook.addPerson(
                TeamsProfileDetail(
                    name = "조재원",
                    part = "백엔드 개발",
                    college = "한국대학교",
                    major = "컴퓨터공학과",
                    leader = false
                )
            )
        }
        return phoneBook
    }
}

class TeamsProfile() {
    // 전화번호부
    val personList = ArrayList<TeamsProfileDetail>()

    fun addPerson(person: TeamsProfileDetail) {
        personList.add(person)
    }
}

class TeamsProfileDetail(
    val name: String,
    val part: String,
    val college: String,
    val major: String,
    val leader: Boolean
) {

}

