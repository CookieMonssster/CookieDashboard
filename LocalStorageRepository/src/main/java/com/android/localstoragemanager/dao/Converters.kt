package com.android.localstoragemanager.dao

import androidx.room.TypeConverter
import com.android.localstoragemanager.model.Mode

/**
 *
 * [Room]
 *
 * Converters class. Room provides functionality for converting between primitive and boxed types,
 * but doesn't allow for object references between entities.
 *
 * More info: https://developer.android.com/training/data-storage/room/referencing-data
 *
 */

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