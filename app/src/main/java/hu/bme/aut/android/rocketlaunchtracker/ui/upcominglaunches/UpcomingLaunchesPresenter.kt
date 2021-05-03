package hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches

import hu.bme.aut.android.rocketlaunchtracker.interactor.launches.LaunchesInteractor
import hu.bme.aut.android.rocketlaunchtracker.model.Launch
import hu.bme.aut.android.rocketlaunchtracker.ui.Presenter
import java.util.*
import java.util.concurrent.Executor
import javax.inject.Inject

class UpcomingLaunchesPresenter @Inject constructor(
    private val executor: Executor,
    private val launchesInteractor: LaunchesInteractor
) : Presenter<UpcomingLaunchesScreen?>() {

    fun onLoad() {
        executor.execute {
            //launchesInteractor.getUpcomingLaunches()
        }
        var launches: MutableList<Launch> = mutableListOf()
        launches.add(
            Launch("gaegagaegaegae", "Falcon 9 Block 5", "SpaceX",
            "Starlink 21", Date(),"TBD")
        )
        launches.add(
            Launch("gaegagaegaegae", "Falcon 9 Block 5", "SpaceX",
                "Starlink 21", Date(),"TBD")
        )
        launches.add(
            Launch("gaegagaegaegae", "Falcon 9 Block 5", "SpaceX",
                "Starlink 21", Date(),"TBD")
        )
        launches.add(
            Launch("gaegagaegaegae", "Falcon 9 Block 5", "SpaceX",
                "Starlink 21", Date(),"TBD")
        )
        launches.add(
            Launch("gaegagaegaegae", "Falcon 9 Block 5", "SpaceX",
                "Starlink 21", Date(),"TBD")
        )
        launches.add(
            Launch("gaegagaegaegae", "Falcon 9 Block 5", "SpaceX",
                "Starlink 21", Date(),"TBD")
        )
        launches.add(
            Launch("gaegagaegaegae", "Falcon 9 Block 5", "SpaceX",
                "Starlink 21", Date(),"TBD")
        )
        launches.add(
            Launch("gaegagaegaegae", "Falcon 9 Block 5", "SpaceX",
                "Starlink 21", Date(),"TBD")
        )
        screen?.showLaunches(launches)
    }

    fun onLaunchSelected(id: String) {
        screen?.openLaunchTrackingScreen(id)
    }

    fun onLaunchTrackingClicked() {
        screen?.openLaunchTrackingScreen(null)
    }

    fun onAboutClicked() {
        screen?.openAboutScreen()
    }
}