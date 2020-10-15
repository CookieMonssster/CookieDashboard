package com.android.repository

import android.util.Log

class LocalStorageRepositoryImpl : LocalStorageRepository {

    override fun initIt() {
        Log.e("klop", "${this.javaClass.simpleName} init!")
    }
}