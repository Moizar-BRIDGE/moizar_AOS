package com.example.moizar

data class CustomCompetitionModel(val type: Int, val text: String, val data: Int, val contentString: String?) {
    companion object {
        const val FIRST_TYPE = 0
        const val ANOTHER_TYPE = 1
    }
}