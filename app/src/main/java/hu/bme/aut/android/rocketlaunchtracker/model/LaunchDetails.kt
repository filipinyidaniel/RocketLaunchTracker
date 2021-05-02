package hu.bme.aut.android.rocketlaunchtracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import hu.bme.aut.android.rocketlaunchtracker.database.DateConverter
import java.util.*

@Entity(tableName = "launches")
@TypeConverters(DateConverter::class)
data class LaunchDetails(
    @PrimaryKey var id : String,
    @ColumnInfo(name = "rocket") var rocket : String,
    @ColumnInfo(name = "provider") var serviceProvider : String,
    @ColumnInfo(name = "mission") var mission : String,
    @ColumnInfo(name = "missiondesc") var missionDescription : String?,
    @ColumnInfo(name = "palnneddate") var palnnedDate : Date?,
    @ColumnInfo(name = "location") var location : String?,
    @ColumnInfo(name = "status") var status : String,
    @ColumnInfo(name = "infourl") var infoURL : String?,
    @ColumnInfo(name = "videourl") var videoURL : String?
)