package com.android.localstoragemanager.repository

import com.android.localstoragemanager.model.SettingsData


interface LocalStorageRepository {
    fun saveSettings(settings: SettingsData)
    fun loadSettings(): SettingsData
}