package hu.bme.aut.android.rocketlaunchtracker.network.models

data class Agency (
    val name: String,
    val id: Int? = null,
    val url: String? = null,
    val featured: Boolean? = null,
    val type: String? = null,
    val country_code: String? = null,
    val abbrev: String? = null,
    val description: String? = null,
    val administrator: String? = null,
    val founding_year: String? = null,
    val launchers: String? = null,
    val spacecraft: String? = null,
    val parent: String? = null,
    val image_url: String? = null
) {

}

