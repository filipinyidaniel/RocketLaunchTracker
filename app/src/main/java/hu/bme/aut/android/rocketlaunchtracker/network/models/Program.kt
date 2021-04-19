package hu.bme.aut.android.rocketlaunchtracker.network.models

import java.util.*

data class Program (
    val name: String,
    val id: Int? = null,
    val url: String? = null,
    val description: String? = null,
    val agencies: Array<AgencySerializerMini>? = null,
    val image_url: String? = null,
    val start_date: Date? = null,
    val end_date: Date? = null,
    val info_url: String? = null,
    val wiki_url: String? = null
) {

}

