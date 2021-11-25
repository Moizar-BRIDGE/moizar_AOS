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
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

        val profileList = createFakeProfileList1(fakeNumber = 20)
        teamslistAdapter =
            TeamsRecyclerAdapter(
                profileList = profileList
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