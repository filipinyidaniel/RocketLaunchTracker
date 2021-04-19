package hu.bme.aut.android.rocketlaunchtracker.interactor.launches

import hu.bme.aut.android.rocketlaunchtracker.model.Launch
import hu.bme.aut.android.rocketlaunchtracker.network.apis.LaunchApi
import javax.inject.Inject

class LaunchesInteractor @Inject constructor(private var launchApi: LaunchApi) {
    fun getUpcomingLaunches() : List<Launch> {
        TODO("Not yet implemented")
    }
}