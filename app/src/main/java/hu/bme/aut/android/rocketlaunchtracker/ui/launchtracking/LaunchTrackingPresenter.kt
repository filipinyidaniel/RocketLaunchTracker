package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import hu.bme.aut.android.rocketlaunchtracker.interactor.launchdetails.LaunchDetailsInteractor
import hu.bme.aut.android.rocketlaunchtracker.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class LaunchTrackingPresenter @Inject constructor(
    private val executor: Executor,
    private val launchDetailsInteractor: LaunchDetailsInteractor
) : Presenter<LaunchTrackingScreen?>() {

    fun loadLaunchDetails(id: String?) {
        executor.execute {
            if (id != null) {
                launchDetailsInteractor.getLaunchDetails(id)
            }
        }
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
