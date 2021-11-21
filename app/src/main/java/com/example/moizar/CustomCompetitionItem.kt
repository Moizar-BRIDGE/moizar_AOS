package com.example.moizar

class CustomCompetitionItem {
    var title: String? = null
    var isActive = false

    fun Item(title: String?, active: Boolean) {
        this.title = title
        isActive = active
    }

}