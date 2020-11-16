package com.android.localstoragemanager.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.android.localstoragemanager.dao.ProfileDao
import com.android.localstoragemanager.model.Profile
import kotlinx.coroutines.flow.Flow

class ProfileRepository(private val profileDao: ProfileDao) {

    val allProfiles: Flow<List<Profile>> = profileDao.getSettings()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(profile: Profile) {
        profileDao.insert(profile)
    }
}