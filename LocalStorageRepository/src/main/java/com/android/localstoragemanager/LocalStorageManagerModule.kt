package com.android.localstoragemanager

import com.android.repository.LocalStorageRepository
import com.android.repository.LocalStorageRepositoryImpl
import org.koin.dsl.module

fun createLocalStorageManagerModule() = createLocalStorageManagerModules()

private fun createLocalStorageManagerModules() = module {
    factory<LocalStorageRepository> { LocalStorageRepositoryImpl() }
}