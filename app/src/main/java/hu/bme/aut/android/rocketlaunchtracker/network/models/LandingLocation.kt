package hu.bme.aut.android.rocketlaunchtracker.network.models

data class LandingLocation (
    val location: Location,
    val id: Int? = null,
    val name: String? = null,
    val abbrev: String? = null,
    val description: String? = null,
    val successful_landings: String? = null
) {

}

