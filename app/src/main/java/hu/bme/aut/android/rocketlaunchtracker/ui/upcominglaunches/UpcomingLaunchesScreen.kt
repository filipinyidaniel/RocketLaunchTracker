package hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches

import hu.bme.aut.android.rocketlaunchtracker.model.Launch

interface UpcomingLaunchesScreen {
    fun showLaunches(launches: List<Launch>)
    fun showProgressBar()
    fun hideProgressBar()
    fun showErrorMessage(message: String)
    fun openLaunchTrackingScreen(id: String?)
    fun openAboutScreen()
}