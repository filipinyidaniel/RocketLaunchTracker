package hu.bme.aut.android.rocketlaunchtracker.network.models

import java.util.*

data class DockingEventSerializerForSpacecraftFlight (
    val docking: Date,
    val spacestation: SpaceStationSerializerForCommon? = null,
    val departure: Date? = null,
    val docking_location: DockingLocation? = null
) {

}

