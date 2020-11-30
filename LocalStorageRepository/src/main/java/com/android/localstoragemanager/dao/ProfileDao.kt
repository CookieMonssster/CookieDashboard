package com.android.localstoragemanager.dao

import androidx.room.*
import com.android.localstoragemanager.model.Profile
import kotlinx.coroutines.flow.Flow

/**
 *
 * [Room]
 *
 * Accessing data using Room DAOs
 *
 * To access your app's data using the Room persistence library, you work with data access objects, or DAOs.
 * This set of Dao objects forms the main component of Room, as each DAO includes methods that offer abstract access to your app's database.
 *
 * More info: https://developer.android.com/training/data-storage/room/accessing-data
 *
 */

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