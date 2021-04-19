package hu.bme.aut.android.rocketlaunchtracker.network.models

data class LauncherDetailed (
    val id: Int? = null,
    val url: String? = null,
    val details: String? = null,
    val flight_proven: Boolean? = null,
    val serial_number: String? = null,
    val status: String? = null,
    val image_url: String? = null,
    val successful_landings: String? = null,
    val attempted_landings: String? = null,
    val flights: String? = null,
    val last_launch_date: String? = null,
    val first_launch_date: String? = null
) {

}

