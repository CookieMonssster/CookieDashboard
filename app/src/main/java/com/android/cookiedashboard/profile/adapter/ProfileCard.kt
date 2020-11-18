package com.android.cookiedashboard.profile.adapter

data class ProfileCard(
    val id: Int,
    val name: String,
    val isProfile: Boolean
) {
    companion object {
        const val WRONG_ID = -1
        const val PROFILE_ID = "profile_id"
    }
}