package hu.bme.aut.android.rocketlaunchtracker.network.models

data class FirstStage (
    val id: Int? = null,
    val type: String? = null,
    val reused: Boolean? = null,
    val launcher_flight_number: String? = null,
    val launcher: LauncherDetailed? = null,
    val landing: Landing? = null,
    val previous_flight_date: String? = null,
    val turn_around_time_days: String? = null,
    val previous_flight: LaunchSerializerMini? = null
) {

}

