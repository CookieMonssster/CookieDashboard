package com.android.cookiedashboard.app

import com.android.cookiedashboard.main.MainViewModel
import com.android.dashboardmanager.addDashboardManagerModule
import com.android.localstoragemanager.dao.ProfileDatabase
import com.android.localstoragemanager.repository.ProfileRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun createAppModule() = mutableListOf<Module>().apply {
    addAll(addDashboardManagerModule())
    add(appModules)
}

private val appModules = module {
    single { ProfileDatabase.getDatabase(androidContext(), CoroutineScope(SupervisorJob())).profileDao() }
    single { ProfileRepository(get()) }
    viewModel { MainViewModel(get()) }
}