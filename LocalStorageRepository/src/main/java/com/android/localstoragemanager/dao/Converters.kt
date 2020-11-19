package com.android.localstoragemanager.dao

import androidx.room.TypeConverter
import com.android.localstoragemanager.model.Mode

class Converters {

    @TypeConverter
    fun fromMode(mode: Mode): Int =
        when(mode) {
            Mode.NORMAL -> NORMAL_MODE
            Mode.DARK -> DARK_MODE
        }

    @TypeConverter
    fun toMode(intMode: Int): Mode =
        when(intMode) {
            DARK_MODE -> Mode.DARK
            else -> Mode.NORMAL
        }

    companion object {
        private const val NORMAL_MODE = 1
        private const val DARK_MODE = 3
    }
}