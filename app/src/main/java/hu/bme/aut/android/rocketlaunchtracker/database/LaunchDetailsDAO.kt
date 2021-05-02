package hu.bme.aut.android.rocketlaunchtracker.database

import androidx.room.*
import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails

@Dao
interface LaunchDetailsDAO {
    @Query("SELECT * FROM launches")
    fun getAllLaunches(): List<LaunchDetails>

    @Insert
    fun insertLaunch(launchDetails: LaunchDetails)

    @Update
    fun updateLaunch(launchDetails: LaunchDetails)

    @Delete
    fun deleteLaunch(launchDetails: LaunchDetails)
}