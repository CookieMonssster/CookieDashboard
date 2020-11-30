package com.android.localstoragemanager

import com.android.localstoragemanager.dao.ProfileDatabase
import com.android.localstoragemanager.repository.ProfileRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 *
 * [Koin]
 *
 * Creating Local Storage modules
 *
 */

fun createLocalStorageManagerModule() = module {
    single { ProfileDatabase.getDatabase(androidContext(), CoroutineScope(SupervisorJob())).profileDao() }
    single { ProfileRepository(get()) }
}