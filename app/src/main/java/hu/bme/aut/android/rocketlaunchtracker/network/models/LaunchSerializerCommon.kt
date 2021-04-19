package hu.bme.aut.android.rocketlaunchtracker.network.models

import java.util.*

data class LaunchSerializerCommon (
    val slug: String,
    val id: java.util.UUID? = null,
    val url: String? = null,
    val launch_library_id: Int? = null,
    val name: String? = null,
    val status: LaunchStatus? = null,
    val net: Date? = null,
    val window_end: Date? = null,
    val window_start: Date? = null,
    val inhold: Boolean? = null,
    val tbdtime: Boolean? = null,
    val tbddate: Boolean? = null,
    val probability: Int? = null,
    val holdreason: String? = null,
    val failreason: String? = null,
    val hashtag: String? = null,
    val launch_service_provider: AgencySerializerMini? = null,
    val rocket: RocketSerializerCommon? = null,
    val mission: Mission? = null,
    val pad: Pad? = null,
    val infoURLs: String? = null,
    val vidURLs: String? = null,
    val webcast_live: Boolean? = null,
    val image: String? = null,
    val infographic: String? = null,
    val program: Array<Program>? = null
) {

}

