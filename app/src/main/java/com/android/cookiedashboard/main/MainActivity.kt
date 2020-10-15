package com.android.cookiedashboard.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.android.cookiedashboard.R
import com.android.dashboardmanager.model.Mode
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.saveLiveData.observe(this, Observer {
            username.text = "Hello ${it.username}!"
            modeSwitch.isChecked = it.mode == Mode.DARK
            ContextCompat.getColor(this, getModeTextColor(it.mode)).let { color ->
                username.setTextColor(color)
                settingsLabel.setTextColor(color)
                modeSwitch.setTextColor(color)
            }
            container.setBackgroundColor(ContextCompat.getColor(this, getModeColor(it.mode)))
        })

        viewModel.loadSettings()

        changeUsernameButton.setOnClickListener {
            viewModel.updateUsername(generateUsername())
            Toast.makeText(this, "Username was changed!", Toast.LENGTH_SHORT).show()
        }

        modeSwitch.setOnCheckedChangeListener { _, checked ->
            viewModel.updateMode(getMode(checked))
            Toast.makeText(this, "Mode was changed!", Toast.LENGTH_SHORT).show()
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

    private fun generateUsername() = listOf("Rysiek", "Cezariusz", "Some User", "Some different user", "Klop").shuffled()[0]

    private fun getMode(checked: Boolean) = if (checked) Mode.DARK else Mode.NORMAL
}