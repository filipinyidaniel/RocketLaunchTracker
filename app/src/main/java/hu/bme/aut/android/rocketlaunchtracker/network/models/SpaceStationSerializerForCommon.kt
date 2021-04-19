package hu.bme.aut.android.rocketlaunchtracker.network.models

import java.util.*

data class SpaceStationSerializerForCommon (
    val name: String,
    val founded: Date,
    val description: String,
    val id: Int? = null,
    val url: String? = null,
    val status: SpaceStationStatus? = null,
    val orbit: String? = null,
    val image_url: String? = null
) {

}

