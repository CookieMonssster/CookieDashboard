package com.android.localstoragemanager.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.kotlinutils.Empty

@Entity(tableName = "profile_table")
data class Profile(
    @ColumnInfo(name = "mode")
    val mode: Mode = Mode.DARK,
    @ColumnInfo(name = "username")
    val username: String = String.Empty,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)