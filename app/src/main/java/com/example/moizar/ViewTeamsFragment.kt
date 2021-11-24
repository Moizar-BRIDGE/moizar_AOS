package com.example.moizar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewTeamsFragment : Fragment() {
    private lateinit var teamslistAdapter: TeamsRecyclerAdapter

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

        val profileList = createFakeProfileList1(fakeNumber = 20)
        teamslistAdapter =
            TeamsRecyclerAdapter(
                profileList = profileList
            )

        val teamsListRecyclerView: RecyclerView = view.findViewById(R.id.teams_recyclerView)
        teamsListRecyclerView.adapter = teamslistAdapter
        teamsListRecyclerView.layoutManager =
            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
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