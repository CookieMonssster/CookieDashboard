package com.android.localstoragemanager.repository

import android.content.SharedPreferences
import com.android.localstoragemanager.model.SettingsData

class SharedPreferencesStorage(private val sharedPreferences: SharedPreferences) : LocalStorageRepository {

    override fun saveSettings(settings: SettingsData) {
        sharedPreferences.edit().apply {
            putInt(MODE, settings.mode)
            putString(USERNAME, settings.userName)
            apply()
        }
    }

    override fun loadSettings(): SettingsData =
        sharedPreferences.run {
            SettingsData(
                getInt(MODE, DEFAULT_MODE),
                getString(USERNAME, DEFAULT_USERNAME) ?: DEFAULT_USERNAME
            )
        }

    companion object {
        private const val MODE = "mode"
        private const val USERNAME = "userName"

        private const val DEFAULT_MODE = 1
        private const val DEFAULT_USERNAME = "Unknown"
    }
}