package hu.bme.aut.android.rocketlaunchtracker.network.models

data class RocketDetailed (
    val id: Int? = null,
    val configuration: LauncherConfigDetail? = null,
    val launcher_stage: Array<FirstStage>? = null,
    val spacecraft_stage: SpacecraftFlightDetailedSerializerForLaunch? = null
) {

}

