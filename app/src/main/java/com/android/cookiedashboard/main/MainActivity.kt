package com.android.cookiedashboard.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.cookiedashboard.R
import com.android.cookiedashboard.profile.adapter.ProfileCard
import com.android.uiextension.launchActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val id = intent.getIntExtra(ProfileCard.PROFILE_ID, ProfileCard.WRONG_ID)


    }

}