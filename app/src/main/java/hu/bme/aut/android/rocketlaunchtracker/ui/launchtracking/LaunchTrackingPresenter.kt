package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import hu.bme.aut.android.rocketlaunchtracker.interactor.launchdetails.LaunchDetailsInteractor
import hu.bme.aut.android.rocketlaunchtracker.ui.Presenter
import javax.inject.Inject

class LaunchTrackingPresenter @Inject constructor(
    private val launchDetailsInteractor: LaunchDetailsInteractor
) : Presenter<LaunchTrackingScreen?>() {

    fun loadLaunchDetails(id: String?) {
        TODO("Not yet implemented")
    }

    fun followLaunch() {
        TODO("Not yet implemented")
    }

    fun unfollowLaunch() {
        TODO("Not yet implemented")
    }

    fun openWebsite() {
        TODO("Not yet implemented")
    }

    fun openVideo() {
        TODO("Not yet implemented")
    }

    fun openUpcomingLaunches() {
        TODO("Not yet implemented")
    }

    fun openAbout() {
        TODO("Not yet implemented")
    }
}