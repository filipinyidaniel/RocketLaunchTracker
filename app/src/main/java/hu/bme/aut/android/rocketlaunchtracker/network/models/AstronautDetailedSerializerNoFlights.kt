package hu.bme.aut.android.rocketlaunchtracker.network.models

data class AstronautDetailedSerializerNoFlights (
    val name: String,
    val date_of_birth: java.time.LocalDateTime,
    val nationality: String,
    val bio: String,
    val id: Int? = null,
    val url: String? = null,
    val type: AstronautType? = null,
    val status: AstronautStatus? = null,
    val agency: AgencySerializerMini? = null,
    val date_of_death: java.time.LocalDateTime? = null,
    val twitter: String? = null,
    val instagram: String? = null,
    val profile_image: String? = null,
    val wiki: String? = null,
    val last_flight: String? = null,
    val first_flight: String? = null
) {

}

