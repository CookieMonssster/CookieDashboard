package com.android.localstoragemanager.dao

import androidx.room.*
import com.android.localstoragemanager.model.Profile
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile_table")
    fun getSettings(): Flow<List<Profile>>

    @Query("SELECT * FROM profile_table WHERE id == :profileId")
    fun load(profileId: Int): Flow<Profile?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(profile: Profile)

    @Update
    suspend fun update(profile: Profile)

    @Query("DELETE FROM profile_table WHERE id == :profileId")
    suspend fun remove(profileId: Int)

    @Query("DELETE FROM profile_table")
    suspend fun deleteAll()
}