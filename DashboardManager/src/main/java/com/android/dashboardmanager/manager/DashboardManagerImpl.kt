package com.android.dashboardmanager.manager

import com.android.dashboardmanager.model.DashboardSettings
import com.android.dashboardmanager.model.toMode
import com.android.localstoragemanager.repository.LocalStorageRepository

class DashboardManagerImpl(private val localStorage: LocalStorageRepository) : DashboardManager {

    override fun loadSettings(): DashboardSettings = localStorage.loadSettings().let {
        DashboardSettings(toMode(it.mode), it.userName)
    }

    override fun saveSettings(settings: DashboardSettings) {
        localStorage.saveSettings(settings.toSettingsData())
    }

}