package hu.bme.aut.android.rocketlaunchtracker.network.models

data class AgencySerializerDetailedCommon (
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
    val launch_library_url: String? = null,
    val total_launch_count: String? = null,
    val consecutive_successful_launches: String? = null,
    val successful_launches: String? = null,
    val failed_launches: String? = null,
    val pending_launches: String? = null,
    val consecutive_successful_landings: String? = null,
    val successful_landings: String? = null,
    val failed_landings: String? = null,
    val attempted_landings: String? = null,
    val info_url: String? = null,
    val wiki_url: String? = null,
    val logo_url: String? = null,
    val image_url: String? = null,
    val nation_url: String? = null
) {

}

