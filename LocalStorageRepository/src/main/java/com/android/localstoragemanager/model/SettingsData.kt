package com.android.localstoragemanager.model

import com.android.kotlinutils.Empty
import com.android.kotlinutils.InvalidValue

data class SettingsData(
    val mode: Int = Int.InvalidValue,
    val userName: String = String.Empty,
)