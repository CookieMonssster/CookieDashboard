package com.android.localstoragemanager.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.kotlinutils.Empty
import com.android.kotlinutils.InvalidValue

@Entity(tableName = "profile_table")
data class Profile(
    @ColumnInfo(name = "mode")
    val mode: Int = Int.InvalidValue,
    @ColumnInfo(name = "username")
    val username: String = String.Empty,
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
)