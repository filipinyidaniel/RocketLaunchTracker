package hu.bme.aut.android.rocketlaunchtracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails

@Database(entities = [LaunchDetails::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun launchDetailsDAO(): LaunchDetailsDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "launch_db"
                )
                .fallbackToDestructiveMigration()
                .build()
                .also { INSTANCE = it }
            }
        }
    }
}