package hu.bme.aut.android.rocketlaunchtracker.network.models

data class DockingEventSerializerForSpacecraftFlight (
    val docking: java.time.LocalDateTime,
    val spacestation: SpaceStationSerializerForCommon? = null,
    val departure: java.time.LocalDateTime? = null,
    val docking_location: DockingLocation? = null
) {

}

