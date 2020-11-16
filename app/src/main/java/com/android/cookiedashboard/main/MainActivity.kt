package com.android.cookiedashboard.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.cookiedashboard.R
import com.android.dashboardmanager.model.Mode
import com.android.localstoragemanager.model.Profile
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.allSettings.observe(this, { profiles ->
            profile_list.text = listProfiles(profiles)
        })

        button.setOnClickListener { addProfile() }
    }

    private fun listProfiles(profiles: List<Profile>): String {
        val sb = StringBuilder()
        profiles.forEach {
            sb.append(it.username + "\n")
        }
        return sb.toString()
    }

    private fun addProfile() {
        viewModel.insert(Profile(1, generateUsername()))
    }

    private fun getModeColor(mode: Mode): Int = when (mode) {
        Mode.DARK -> R.color.dark_mode_color
        Mode.NORMAL -> R.color.normal_mode_color
    }

    private fun getModeTextColor(mode: Mode): Int = when (mode) {
        Mode.DARK -> R.color.dark_mode_text_color
        Mode.NORMAL -> R.color.normal_mode_text_color
    }

    private fun generateUsername() = listOf("Rysiek", "Cezariusz", "Some User", "Some different user", "Klop").shuffled()[0]

    private fun getMode(checked: Boolean) = if (checked) Mode.DARK else Mode.NORMAL
}