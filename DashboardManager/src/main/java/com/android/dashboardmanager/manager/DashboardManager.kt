package com.android.dashboardmanager.manager

import com.android.dashboardmanager.model.DashboardSettings

interface DashboardManager {
    fun loadSettings(): DashboardSettings
    fun saveSettings(settings: DashboardSettings)
}