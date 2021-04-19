package hu.bme.aut.android.rocketlaunchtracker.network.models

data class SpacecraftFlightDetailedSerializerForLaunch (
    val id: Int,
    val url: String? = null,
    val mission_end: java.time.LocalDateTime? = null,
    val destination: String? = null,
    val launch_crew: Array<AstronautFlight>? = null,
    val onboard_crew: Array<AstronautFlight>? = null,
    val landing_crew: Array<AstronautFlight>? = null,
    val spacecraft: SpacecraftDetailedNoFlights? = null,
    val docking_events: Array<DockingEventSerializerForSpacecraftFlight>? = null
) {

}

