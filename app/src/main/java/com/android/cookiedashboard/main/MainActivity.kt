package com.android.cookiedashboard.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.cookiedashboard.R
import com.android.cookiedashboard.databinding.ActivityMainBinding
import com.android.cookiedashboard.profile.adapter.ProfileCard
import com.android.kotlinutils.InvalidValue
import com.android.localstoragemanager.model.Mode
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private var id: Int = Int.InvalidValue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        id = intent.getIntExtra(ProfileCard.PROFILE_ID, ProfileCard.WRONG_ID)

        viewModel.loadProfile(id).observe(this, {
            it?.let {
                binding.apply {
                    profileName.text = it.username
                    profileName.setTextColor(ContextCompat.getColor(root.context, getTextColor(it.mode)))
                    modeSwitch.isChecked = it.mode == Mode.DARK
                    container.setBackgroundColor(ContextCompat.getColor(root.context, getBackgroundColor(it.mode)))
                }
            }
        })
        prepareView()
    }

    private fun prepareView() {
        // view binding
        binding.apply {
            menuSix.prepareSixthElement(getString(R.string.settings), R.drawable.ic_settings) {
                Toast.makeText(root.context, "Settings screen should open N O W !", Toast.LENGTH_SHORT).show()
            }
            modeSwitch.setOnCheckedChangeListener { _, isChecked ->
                viewModel.updateProfileMode(getModeFromSwitch(isChecked))
            }

            removeButton.setOnClickListener {
                viewModel.removeProfile()
                finish()
            }
        }
    }

    private fun getModeFromSwitch(isChecked: Boolean) =
        if (isChecked) Mode.DARK
        else Mode.NORMAL

    private fun getBackgroundColor(mode: Mode) =
        when (mode) {
            Mode.NORMAL -> R.color.normal_mode_color
            Mode.DARK -> R.color.dark_mode_color
        }

    private fun getTextColor(mode: Mode) =
        when (mode) {
            Mode.NORMAL -> R.color.normal_mode_text_color
            Mode.DARK -> R.color.dark_mode_text_color
        }
}