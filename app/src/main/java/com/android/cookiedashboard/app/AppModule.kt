package com.android.cookiedashboard.app

import com.android.cookiedashboard.main.MainViewModel
import com.android.dashboardmanager.addDashboardManagerModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun createAppModule() = mutableListOf<Module>().apply {
    addAll(addDashboardManagerModule())
    add(appModules)
}

private val appModules = module {
    viewModel { MainViewModel(get()) }
}