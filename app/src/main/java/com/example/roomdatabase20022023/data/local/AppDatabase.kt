package com.example.roomdatabase20022023.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase20022023.data.local.entity.Priority
import com.example.roomdatabase20022023.data.local.entity.WorkEntity

/**
 * Created by pphat on 5/17/2023.
 */

@Database(entities = [WorkEntity::class, Priority::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun appDao(): AppDao

    companion object {
        private var instance: AppDatabase? = null

        fun createDatabase(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
            }
            return instance
        }
    }

}
