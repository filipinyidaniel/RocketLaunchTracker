package hu.bme.aut.android.rocketlaunchtracker.ui.about

import hu.bme.aut.android.rocketlaunchtracker.interactor.about.AboutInteractor
import hu.bme.aut.android.rocketlaunchtracker.ui.Presenter
import javax.inject.Inject

class AboutPresenter @Inject constructor(
    private val aboutInteractor: AboutInteractor
) : Presenter<AboutScreen?>() {

    fun onLoad() {
    }

    fun onLaunchTrackingClicked() {
        screen?.openLaunchTrackingScreen()
    }

    fun onUpcomingLaunchesClicked() {
        screen?.openUpcomingLaunchesScreen()
    }
}