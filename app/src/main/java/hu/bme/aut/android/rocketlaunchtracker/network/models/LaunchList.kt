package hu.bme.aut.android.rocketlaunchtracker.network.models

data class LaunchList (
    val count: Int,
    val results: Array<LaunchSerializerCommon>,
    val next: String? = null,
    val previous: String? = null
) {

}

