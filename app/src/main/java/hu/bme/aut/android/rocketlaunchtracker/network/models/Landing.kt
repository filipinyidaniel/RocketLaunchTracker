package hu.bme.aut.android.rocketlaunchtracker.network.models

data class Landing (
    val id: Int? = null,
    val attempt: Boolean? = null,
    val success: Boolean? = null,
    val description: String? = null,
    val location: LandingLocation? = null,
    val type: LandingType? = null
) {

}

