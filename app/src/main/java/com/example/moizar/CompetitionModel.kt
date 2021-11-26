package com.example.moizar

class CompetitionModel() {
    // 가짜 프로필 정보
    val competitionList = ArrayList<CompetitionDetail>()

    fun addCompetition(competition: CompetitionDetail) {
        competitionList.add(competition)
    }
}

class CompetitionDetail(
    val cNum: Int,
    val name: String,
    val image: String,
    val dDay: String,
    val cateName: String,
    val isActive: Boolean,
    val viewtype: Int
)