package hu.bme.aut.android.rocketlaunchtracker.network.models

import java.util.*

data class SpacecraftConfigurationDetail (
    val name: String,
    val id: Int? = null,
    val url: String? = null,
    val type: SpacecraftConfigType? = null,
    val agency: Agency? = null,
    val in_use: Boolean? = null,
    val capability: String? = null,
    val history: String? = null,
    val details: String? = null,
    val maiden_flight: Date? = null,
    val height: java.math.BigDecimal? = null,
    val diameter: java.math.BigDecimal? = null,
    val human_rated: Boolean? = null,
    val crew_capacity: Int? = null,
    val payload_capacity: Int? = null,
    val flight_life: String? = null,
    val image_url: String? = null,
    val nation_url: String? = null,
    val wiki_link: String? = null,
    val info_link: String? = null
) {

}

