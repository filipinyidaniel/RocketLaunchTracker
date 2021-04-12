package hu.bme.aut.android.rocketlaunchtracker.ui.about

interface AboutScreen {
    fun showAppInfo(name: String, version: String, developer: String)
    fun goToLaunchTrackingScreen()
    fun goToUpcomingLaunchesScreen()
}