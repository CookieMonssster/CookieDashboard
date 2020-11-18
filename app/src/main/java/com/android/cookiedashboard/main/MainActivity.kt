package com.android.cookiedashboard.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.cookiedashboard.R
import com.android.cookiedashboard.main.adapter.MainActivityListener
import com.android.cookiedashboard.main.adapter.ProfileAdapter
import com.android.dashboardmanager.model.Mode
import com.android.localstoragemanager.model.Profile
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), MainActivityListener {

    private val viewModel: MainViewModel by viewModel()
    private val profileAdapter = ProfileAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycleView()

        viewModel.allSettings.observe(this, { profiles ->
            profileAdapter.updateProfileList(profiles)
        })

        //button.setOnClickListener { addProfile() }
    }

    override fun addProfile() {
        viewModel.insert(Profile(1, generateUsername()))
    }

    private fun setupRecycleView() {
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = profileAdapter
        }
    }

    private fun listProfiles(profiles: List<String>): String =
        StringBuilder().apply {
            profiles.forEach {
                append(it + "\n")
            }
        }.toString()

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