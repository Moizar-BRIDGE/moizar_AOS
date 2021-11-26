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
        val profileList = createFakeProfileList(fakeNumber = 35)
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