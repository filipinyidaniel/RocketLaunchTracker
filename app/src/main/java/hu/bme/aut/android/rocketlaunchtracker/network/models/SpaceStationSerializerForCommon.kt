package hu.bme.aut.android.rocketlaunchtracker.network.models

data class SpaceStationSerializerForCommon (
    val name: String,
    val founded: java.time.LocalDateTime,
    val description: String,
    val id: Int? = null,
    val url: String? = null,
    val status: SpaceStationStatus? = null,
    val orbit: String? = null,
    val image_url: String? = null
) {

}

