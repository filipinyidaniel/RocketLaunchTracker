package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import hu.bme.aut.android.rocketlaunchtracker.interactor.launchdetails.LaunchDetailsInteractor
import hu.bme.aut.android.rocketlaunchtracker.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class LaunchTrackingPresenter @Inject constructor(
    private val executor: Executor,
    private val launchDetailsInteractor: LaunchDetailsInteractor
) : Presenter<LaunchTrackingScreen?>() {

    fun onLoad(id: String?) {
        executor.execute {
            if (id != null) {
                //launchDetailsInteractor.getLaunchDetails(id)
            }
        }
    }

    fun onFollowClicked() {
        TODO("Not yet implemented")
    }

    fun onUnfollowClicked() {
        TODO("Not yet implemented")
    }

    fun onWebsiteClicked() {
        TODO("Not yet implemented")
    }

    fun onVideoClicked() {
        TODO("Not yet implemented")
    }

    fun onUpcomingLaunchesClicked() {
        screen?.openUpcomingLaunchesScreen()
    }

    fun onAboutClicked() {
        screen?.openAboutScreen()
    }
}
