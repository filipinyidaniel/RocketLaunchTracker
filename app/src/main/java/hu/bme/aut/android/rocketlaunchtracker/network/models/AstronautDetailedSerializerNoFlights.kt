package hu.bme.aut.android.rocketlaunchtracker.network.models

import java.util.*

data class AstronautDetailedSerializerNoFlights (
    val name: String,
    val date_of_birth: Date,
    val nationality: String,
    val bio: String,
    val id: Int? = null,
    val url: String? = null,
    val type: AstronautType? = null,
    val status: AstronautStatus? = null,
    val agency: AgencySerializerMini? = null,
    val date_of_death: Date? = null,
    val twitter: String? = null,
    val instagram: String? = null,
    val profile_image: String? = null,
    val wiki: String? = null,
    val last_flight: String? = null,
    val first_flight: String? = null
) {

}

