package hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches

import hu.bme.aut.android.rocketlaunchtracker.interactor.launches.LaunchesInteractor
import hu.bme.aut.android.rocketlaunchtracker.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class UpcomingLaunchesPresenter @Inject constructor(
    private val executor: Executor,
    private val launchesInteractor: LaunchesInteractor
) : Presenter<UpcomingLaunchesScreen?>() {

    fun loadUpcomingLaunches() {
        executor.execute {
            launchesInteractor.getUpcomingLaunches()
        }
    }

    fun openLaunchDetails(id: String) {
        TODO("Not yet implemented")
    }

    fun openLaunchTracking() {
        TODO("Not yet implemented")
    }

    fun openAbout() {
        TODO("Not yet implemented")
    }
}