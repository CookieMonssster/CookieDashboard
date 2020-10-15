package com.android.cookiedashboard.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dashboardmanager.manager.DashboardManager
import com.android.dashboardmanager.model.DashboardSettings
import com.android.dashboardmanager.model.Mode

class MainViewModel(private val dashboardManager: DashboardManager) : ViewModel() {

    private val _saveLiveData = MutableLiveData<DashboardSettings>()
    val saveLiveData: LiveData<DashboardSettings> get() = _saveLiveData

    private lateinit var currentSettings: DashboardSettings

    fun loadSettings() {
        dashboardManager.loadSettings().let {
            currentSettings = it
            _saveLiveData.value = it
        }
    }

    fun updateUsername(newUsername: String) = saveSettings(DashboardSettings(currentSettings.mode, newUsername))

    fun updateMode(mode: Mode) = saveSettings(DashboardSettings(mode, currentSettings.username))

    private fun saveSettings(settings: DashboardSettings) {
        dashboardManager.saveSettings(settings)
        loadSettings()
    }
}