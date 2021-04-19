package hu.bme.aut.android.rocketlaunchtracker.network.models

data class Pad (
    val location: Location,
    val id: Int? = null,
    val url: String? = null,
    val agency_id: Int? = null,
    val name: String? = null,
    val info_url: String? = null,
    val wiki_url: String? = null,
    val map_url: String? = null,
    val latitude: String? = null,
    val longitude: String? = null,
    val map_image: String? = null,
    val total_launch_count: String? = null
) {

}

