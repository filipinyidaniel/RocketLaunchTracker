package hu.bme.aut.android.rocketlaunchtracker.network.models

data class SpacecraftDetailedNoFlights (
    val name: String,
    val description: String,
    val id: Int? = null,
    val url: String? = null,
    val serial_number: String? = null,
    val status: SpacecraftStatus? = null,
    val spacecraft_config: SpacecraftConfigurationDetail? = null
) {

}

