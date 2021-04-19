package hu.bme.aut.android.rocketlaunchtracker.network.models

import java.util.*

data class LauncherConfigDetail (
    val name: String,
    val id: Int? = null,
    val launch_library_id: Int? = null,
    val url: String? = null,
    val description: String? = null,
    val family: String? = null,
    val full_name: String? = null,
    val manufacturer: AgencySerializerDetailedCommon? = null,
    val program: Array<Program>? = null,
    val variant: String? = null,
    val alias: String? = null,
    val min_stage: Int? = null,
    val max_stage: Int? = null,
    val length: java.math.BigDecimal? = null,
    val diameter: java.math.BigDecimal? = null,
    val maiden_flight: Date? = null,
    val launch_mass: Int? = null,
    val leo_capacity: Int? = null,
    val gto_capacity: Int? = null,
    val to_thrust: Int? = null,
    val apogee: Int? = null,
    val vehicle_range: Int? = null,
    val image_url: String? = null,
    val info_url: String? = null,
    val wiki_url: String? = null,
    val total_launch_count: String? = null,
    val consecutive_successful_launches: String? = null,
    val successful_launches: String? = null,
    val failed_launches: String? = null,
    val pending_launches: String? = null
) {

}

