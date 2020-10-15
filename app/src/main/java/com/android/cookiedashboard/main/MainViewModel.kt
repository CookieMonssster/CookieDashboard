package com.android.cookiedashboard.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dashboardmanager.manager.DashboardManager
import com.android.dashboardmanager.model.DashboardSettings

class MainViewModel(private val dashboardManager: DashboardManager) : ViewModel() {

    private val _saveLiveData = MutableLiveData<DashboardSettings>()
    val saveLiveData: LiveData<DashboardSettings> get() = _saveLiveData

    private lateinit var currentSettings: DashboardSettings

    fun loadSettings() {
        _saveLiveData.value = dashboardManager.loadSettings()
    }

    fun saveSettings(settings: DashboardSettings) {
        dashboardManager.saveSettings(settings)
        loadSettings()
    }
}