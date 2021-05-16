package hu.bme.aut.android.rocketlaunchtracker.database

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        context: Context
    ) = AppDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideLaunchDetailsDAO(
        appDatabase: AppDatabase
    ) = appDatabase.launchDetailsDAO()

}