package hu.bme.aut.android.rocketlaunchtracker.network.models

import java.util.*

data class SpacecraftFlightDetailedSerializerForLaunch (
    val id: Int,
    val url: String? = null,
    val mission_end: Date? = null,
    val destination: String? = null,
    val launch_crew: Array<AstronautFlight>? = null,
    val onboard_crew: Array<AstronautFlight>? = null,
    val landing_crew: Array<AstronautFlight>? = null,
    val spacecraft: SpacecraftDetailedNoFlights? = null,
    val docking_events: Array<DockingEventSerializerForSpacecraftFlight>? = null
) {

}

