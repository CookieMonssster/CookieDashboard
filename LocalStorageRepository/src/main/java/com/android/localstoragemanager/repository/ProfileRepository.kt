package com.android.localstoragemanager.repository

import androidx.annotation.WorkerThread
import com.android.localstoragemanager.dao.ProfileDao
import com.android.localstoragemanager.model.Profile
import kotlinx.coroutines.flow.Flow

class ProfileRepository(private val profileDao: ProfileDao) {

    val allProfiles: Flow<List<Profile>> = profileDao.getSettings()

    fun load(id: Int): Flow<Profile?> = profileDao.load(id)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(profile: Profile) = profileDao.insert(profile)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(profile: Profile) = profileDao.update(profile)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun remove(profileId: Int) = profileDao.remove(profileId)
}