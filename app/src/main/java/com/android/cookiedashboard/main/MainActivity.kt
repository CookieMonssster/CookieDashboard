package com.android.cookiedashboard.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.cookiedashboard.R
import com.android.cookiedashboard.profile.adapter.ProfileCard
import com.android.localstoragemanager.model.Mode
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    private var id: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        id = intent.getIntExtra(ProfileCard.PROFILE_ID, ProfileCard.WRONG_ID)

        viewModel.loadProfile(id).observe(this, {
            profile_name.text = it.username
            profile_name.setTextColor(ContextCompat.getColor(this, getTextColor(it.mode)))
            mode_switch.isChecked = it.mode == Mode.DARK
            container.setBackgroundColor(ContextCompat.getColor(this, getBackgroundColor(it.mode)))
        })

        mode_switch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.updateProfileMode(getModeFromSwitch(isChecked))
        }
    }

    private fun getModeFromSwitch(isChecked: Boolean) =
        if (isChecked) Mode.DARK
        else Mode.NORMAL

    private fun getBackgroundColor(mode: Mode) =
        when(mode) {
            Mode.NORMAL -> R.color.normal_mode_color
            Mode.DARK -> R.color.dark_mode_color
        }

    private fun getTextColor(mode: Mode) =
        when(mode) {
            Mode.NORMAL -> R.color.normal_mode_text_color
            Mode.DARK -> R.color.dark_mode_text_color
        }
}