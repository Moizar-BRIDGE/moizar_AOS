package com.example.moizar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val fragmentViewTeams by lazy { ViewTeamsFragment() }
    private val fragmentViewPeoples by lazy { ViewPeoplesFragment() }
    private val fragmentViewCompetition by lazy { ViewCompetitionFragment() }
    private val fragmentMain by lazy { ViewMainFragment() }
    private lateinit var massage : ImageButton
    private lateinit var alarm : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        massage = findViewById(R.id.msg_ic)
        alarm = findViewById(R.id.notification_ic)
        massage.setOnClickListener {
            val intent = Intent(this, ChatListActivity::class.java)
            startActivity(intent)
            finish()
        }
        alarm.setOnClickListener {
            val intent = Intent(this, AlarmActivity::class.java)
            startActivity(intent)
            finish()
        }

        val customBottomNavigationView1: CustomBottomNavigationView1 =
            findViewById(R.id.customBottomBar)
        customBottomNavigationView1.inflateMenu(R.layout.bottom_menu)
        initNavigationBar()

    }

    private fun initNavigationBar() {
        val customBottomNavigationView1: CustomBottomNavigationView1 =
            findViewById(R.id.customBottomBar)
        val teamsWriteBtn: FloatingActionButton = findViewById(R.id.teams_write_btn)
        val intent = Intent(this, TeamsWriteActivity::class.java)
        customBottomNavigationView1.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.action_main -> {
                        changeFragment(fragmentMain)
                        teamsWriteBtn.visibility = View.INVISIBLE
                    }
                    R.id.action_teams -> {
                        changeFragment(fragmentViewTeams)
                        teamsWriteBtn.visibility = View.VISIBLE
                        teamsWriteBtn.setOnClickListener {
                            startActivity(intent)
                        }
                    }
                    R.id.action_peoples -> {
                        changeFragment(fragmentViewPeoples)
                        teamsWriteBtn.visibility = View.INVISIBLE
                    }
                    R.id.action_competition -> {
                        changeFragment(fragmentViewCompetition)
                        teamsWriteBtn.visibility = View.INVISIBLE
                    }
                }
                true
            }
            selectedItemId = R.id.action_main
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.view_Pager, fragment).commit()
    }


}