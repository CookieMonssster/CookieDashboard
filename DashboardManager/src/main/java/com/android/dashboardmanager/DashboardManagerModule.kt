package com.android.dashboardmanager

import com.android.localstoragemanager.createLocalStorageManagerModule
import org.koin.dsl.module

fun addDashboardManagerModule() = createDashboardManagerModules()
    .plus(createLocalStorageManagerModule())

private fun createDashboardManagerModules() = module {
    //factory<DashboardManager> { DashboardManagerImpl(get()) }
}