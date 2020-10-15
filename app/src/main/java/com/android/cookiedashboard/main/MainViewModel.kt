package com.android.cookiedashboard.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.android.dashboardmanager.manager.DashboardManager

class MainViewModel(private val dashboardManager: DashboardManager) : ViewModel() {

    fun initIt() {
        Log.e("klop", "${this.javaClass.name} init")
        dashboardManager.initIt()
    }
}