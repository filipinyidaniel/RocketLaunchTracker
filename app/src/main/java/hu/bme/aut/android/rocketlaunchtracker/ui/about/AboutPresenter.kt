package hu.bme.aut.android.rocketlaunchtracker.ui.about

import hu.bme.aut.android.rocketlaunchtracker.interactor.about.AboutInteractor
import hu.bme.aut.android.rocketlaunchtracker.ui.Presenter
import javax.inject.Inject

class AboutPresenter @Inject constructor(
    private val aboutInteractor: AboutInteractor
) : Presenter<AboutScreen?>() {

    fun loadAppInfo() {
        TODO("Not yet implemented")
    }

    fun openLaunchTracking() {
        TODO("Not yet implemented")
    }

    fun openUpcomingLaunches() {
        TODO("Not yet implemented")
    }
}