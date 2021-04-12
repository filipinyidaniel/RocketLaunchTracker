package hu.bme.aut.android.rocketlaunchtracker.ui.about

interface AboutScreen {
    fun showAppInfo(appVersion: String, copyright: String)
    fun goToLaunchTrackingScreen()
    fun goToUpcomingLaunchesScreen()
}