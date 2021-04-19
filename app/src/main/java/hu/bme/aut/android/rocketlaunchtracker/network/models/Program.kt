package hu.bme.aut.android.rocketlaunchtracker.network.models

data class Program (
    val name: String,
    val id: Int? = null,
    val url: String? = null,
    val description: String? = null,
    val agencies: Array<AgencySerializerMini>? = null,
    val image_url: String? = null,
    val start_date: java.time.LocalDateTime? = null,
    val end_date: java.time.LocalDateTime? = null,
    val info_url: String? = null,
    val wiki_url: String? = null
) {

}

