package hu.bme.aut.android.rocketlaunchtracker.model

import java.util.*

data class Launch(
    var id : String,
    var rocket : String,
    var serviceProvider : String,
    var mission : String,
    var palnnedDate : Date?,
    var status : String
)