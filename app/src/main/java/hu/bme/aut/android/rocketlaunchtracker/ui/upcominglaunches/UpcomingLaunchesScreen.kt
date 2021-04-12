package hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches

import hu.bme.aut.android.rocketlaunchtracker.model.Launch

interface UpcomingLaunchesScreen {
    fun showLaunches(launches: List<Launch>)
    fun showErrorMessage(message: String)
    fun goToLaunchTrackingScreen(id: String?)
    fun goToAboutScreen()
}