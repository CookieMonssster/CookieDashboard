package com.android.localstoragemanager

import android.content.Context
import com.android.localstoragemanager.repository.LocalStorageRepository
import com.android.localstoragemanager.repository.SharedPreferencesStorage
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

fun createLocalStorageManagerModule() = createLocalStorageManagerModules()

private fun createLocalStorageManagerModules() = module {
    factory { androidContext().getSharedPreferences(LocalStorage, Context.MODE_PRIVATE) }
    factory<LocalStorageRepository> { SharedPreferencesStorage(get()) }
}

private const val LocalStorage = "LocalStorage"