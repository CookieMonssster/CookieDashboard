package com.android.dashboardmanager.model

import com.android.kotlinutils.Empty
import com.android.localstoragemanager.model.SettingsData

data class DashboardSettings(
    val mode: Mode = Mode.NORMAL,
    val username: String = String.Empty,
) {
    fun toSettingsData() = SettingsData(fromMode(mode), username)
}