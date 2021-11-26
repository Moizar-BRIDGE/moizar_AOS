package com.example.moizar

class TeamsModel() {
    // 가짜 프로필 정보
    val teamsList = ArrayList<TeamsDetail>()

    fun addTeams(teams: TeamsDetail) {
        teamsList.add(teams)
    }
}

class TeamsDetail(
    val tNum: Int,
    val cNum: Int,
    val teamsTitle: String,
    val competitionName: String,
    val cateName: String,
    val dDay: String,
    val isBookmarked : Boolean,
    val isActive: Boolean,
    val viewtype: Int
)