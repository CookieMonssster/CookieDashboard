package com.android.cookiedashboard.app

import com.android.cookiedashboard.main.MainViewModel
import com.android.cookiedashboard.profile.ProfileViewModel
import com.android.localstoragemanager.createLocalStorageManagerModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun createAppModule() = mutableListOf<Module>().apply {
    add(createLocalStorageManagerModule())
    add(appModules)
}

private val appModules = module {
    viewModel { ProfileViewModel(get()) }
    viewModel { MainViewModel(get()) }
}