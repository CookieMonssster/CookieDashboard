package com.android.dashboardmanager.manager

import android.util.Log
import com.android.repository.LocalStorageRepository

class DashboardManagerImpl(private val localStorage: LocalStorageRepository) : DashboardManager {

    override fun initIt() {
        Log.e("klop", "${this.javaClass.simpleName} init")
        localStorage.initIt()
    }
}