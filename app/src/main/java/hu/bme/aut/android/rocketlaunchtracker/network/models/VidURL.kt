package hu.bme.aut.android.rocketlaunchtracker.network.models

data class VidURL (
    val url: String,
    val priority: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val feature_image: String? = null
) {

}

