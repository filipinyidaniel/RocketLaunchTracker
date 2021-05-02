package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails

interface LaunchTrackingScreen {
    fun showLaunchDetails(details: LaunchDetails)
    fun enableWebsiteButton()
    fun disableWebsiteButton()
    fun enableVideoButton()
    fun disableVideoButton()
    fun showFollowButton()
    fun hideFollowButton()
    fun showUnfollowButton()
    fun hideUnfollowButton()
    fun showNoTracking()
    fun showInfoMessage(message: String)
    fun showErrorMessage(message: String)
    fun openURL(url: String)
    fun openUpcomingLaunchesScreen()
    fun openAboutScreen()
}