package com.android.cookiedashboard.profile

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.android.cookiedashboard.R
import com.android.cookiedashboard.profile.adapter.ProfileActivityListener
import com.android.cookiedashboard.profile.adapter.ProfileAdapter
import com.android.dashboardmanager.model.Mode
import com.android.localstoragemanager.model.Profile
import kotlinx.android.synthetic.main.profile_activity_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileActivity : AppCompatActivity(), ProfileActivityListener {

    private val viewModel: ProfileViewModel by viewModel()
    private val profileAdapter = ProfileAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.profile_activity_layout)
        setupRecycleView()

        viewModel.allSettings.observe(this, { profiles ->
            profileAdapter.updateProfileList(profiles)
        })
    }

    override fun addProfile() {
        viewModel.insert(Profile(1, generateUsername()))
    }

    override fun getContext(): Context = this

    private fun setupRecycleView() {
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, COLUMNS_IN_PORTRAIT_MODE)
            adapter = profileAdapter
        }
    }

    private fun getModeColor(mode: Mode): Int = when (mode) {
        Mode.DARK -> R.color.dark_mode_color
        Mode.NORMAL -> R.color.normal_mode_color
    }

    private fun getModeTextColor(mode: Mode): Int = when (mode) {
        Mode.DARK -> R.color.dark_mode_text_color
        Mode.NORMAL -> R.color.normal_mode_text_color
    }

    private fun generateUsername() = listOf("Rysiek", "Cezariusz", "Some User", "Grażyna", "Klop").shuffled()[0]

    companion object {
        private const val COLUMNS_IN_PORTRAIT_MODE = 2
    }
}