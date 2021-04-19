package hu.bme.aut.android.rocketlaunchtracker.network.models

data class Mission (
    val orbit: Orbit,
    val id: Int? = null,
    val launch_library_id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val launch_designator: String? = null,
    val type: String? = null
) {

}

