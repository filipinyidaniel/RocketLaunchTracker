package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails

interface LaunchTrackingScreen {
    fun showLaunchDetails(details: LaunchDetails)
    fun showFollowButton()
    fun hideFollowButton()
    fun showUnfollowButton()
    fun hideUnfollowButton()
    fun showProgressBar()
    fun hideProgressBar()
    fun showMessage(message: String)
    fun openURL(url: String)
    fun openUpcomingLaunchesScreen()
    fun openAboutScreen()
}