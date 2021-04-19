package hu.bme.aut.android.rocketlaunchtracker.network.models

data class LauncherConfigList (
    val name: String,
    val id: Int? = null,
    val launch_library_id: Int? = null,
    val url: String? = null,
    val family: String? = null,
    val full_name: String? = null,
    val variant: String? = null
) {

}

