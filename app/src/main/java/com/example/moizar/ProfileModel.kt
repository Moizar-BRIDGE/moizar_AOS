package com.example.moizar

class ProfileModel() {
    // 가짜 프로필 정보
    val profileList = ArrayList<ProfileViewDetail>()

    fun addPerson(person: ProfileViewDetail) {
        profileList.add(person)
    }
}

class ProfileViewDetail(
    val uid: String,
    val name: String,
    val image: String,
    val email: String,
    val major: String,
    val part: String,
    val school: String,
    val resume: String,
    val experience: String,
    val isLiked: Boolean,
)