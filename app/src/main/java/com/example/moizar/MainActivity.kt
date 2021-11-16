package com.example.moizar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private val fragmentViewTeams by lazy { ViewTeamsFragment() }
    private val fragmentViewPeoples by lazy { ViewPeoplesFragment() }
    private val fragmentViewCompetition by lazy { ViewCompetitionFragment() }
    private val fragmentMain by lazy { ViewMainFragment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customBottomNavigationView1: CustomBottomNavigationView1 =
            findViewById(R.id.customBottomBar)
        customBottomNavigationView1.inflateMenu(R.layout.bottom_menu)
        initNavigationBar()
    }

    private fun initNavigationBar() {
        val customBottomNavigationView1: CustomBottomNavigationView1 =
            findViewById(R.id.customBottomBar)
        customBottomNavigationView1.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.action_main -> {
                        changeFragment(fragmentMain)
                    }
                    R.id.action_teams -> {
                        changeFragment(fragmentViewTeams)
                    }
                    R.id.action_peoples -> {
                        changeFragment(fragmentViewPeoples)
                    }
                    R.id.action_competition -> {
                        changeFragment(fragmentViewCompetition)
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