package com.android.cookiedashboard.app

import android.app.Application
import com.android.localstoragemanager.dao.ProfileDatabase
import com.android.localstoragemanager.repository.ProfileRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CookieDashboardApp: Application()  {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CookieDashboardApp)
            modules(createAppModule())
        }
    }
}