package com.android.localstoragemanager.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.android.localstoragemanager.model.Mode
import com.android.localstoragemanager.model.Profile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Profile::class], version = 1)
@TypeConverters(Converters::class)
abstract class ProfileDatabase : RoomDatabase() {

    abstract fun profileDao(): ProfileDao

    private class ProfileDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.profileDao())
                }
            }
        }

        suspend fun populateDatabase(profileDao: ProfileDao) {
            profileDao.deleteAll()
            profileDao.insert(Profile(Mode.DARK, "Rysiek"))
            profileDao.insert(Profile(Mode.NORMAL, "przestań!"))
        }
    }

    companion object {
        private const val DATABASE_NAME = "app_database"

        @Volatile
        private var INSTANCE: ProfileDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope) =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProfileDatabase::class.java,
                    DATABASE_NAME
                )
                    .addCallback(ProfileDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
    }
}