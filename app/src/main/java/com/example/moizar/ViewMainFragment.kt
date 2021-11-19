package com.example.moizar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewMainFragment : Fragment() {

    private lateinit var listAdapter: ProfileListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val profileList = createFakeProfileList(fakeNumber = 30)
        listAdapter =
            ProfileListRecyclerAdapter(
                profileList = profileList
            )

        val profileList_recycler_view : RecyclerView = requireView().findViewById(R.id.profile_recycler_view)
        profileList_recycler_view.adapter = listAdapter
        profileList_recycler_view.layoutManager =
            LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
    }

    fun createFakeProfileList(
        fakeNumber: Int = 10,
        profileList: ProfileList = ProfileList()
    ): ProfileList {
        for (i in 0 until fakeNumber) {
            profileList.addPerson(
                ProfileDetail(
                    name = "" + i + "사람",
                    part = "" + i + "분야",
                    school = "" + i + "공학대학교",
                    major = "" + i + "컴퓨터공학과",
                )
            )
        }
        return profileList
    }
}


//// 서버 연동하고 아래 삭제할거임
//// 가짜 데이터임
class ProfileListRecyclerAdapter(
    val profileList: ProfileList,
) : RecyclerView.Adapter<ProfileListRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView

        init {
            personName = itemView.findViewById(R.id.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(profileList.personList.get(position).name)
    }

    override fun getItemCount(): Int {
        return profileList.personList.size
    }
}

////class 생성
class ProfileList() {
    // 가짜 프로필 정보
    val personList = ArrayList<ProfileDetail>()

    fun addPerson(person: ProfileDetail) {
        personList.add(person)
    }
}

class ProfileDetail(val name: String, val part: String, val school: String, val major: String) {

}