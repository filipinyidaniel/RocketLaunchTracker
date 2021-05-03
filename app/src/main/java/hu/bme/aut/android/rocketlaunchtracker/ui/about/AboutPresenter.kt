package hu.bme.aut.android.rocketlaunchtracker.ui.about

import hu.bme.aut.android.rocketlaunchtracker.interactor.about.AboutInteractor
import hu.bme.aut.android.rocketlaunchtracker.ui.Presenter
import javax.inject.Inject

class AboutPresenter @Inject constructor(
    private val aboutInteractor: AboutInteractor
) : Presenter<AboutScreen?>() {

    fun onLoad() {
        var appVersion = "Rocket Launch Tracker v1.0.0"
        var copyright = "Copyright © 2021 Daniel Filipinyi"
        screen?.showAppInfo(appVersion, copyright)
    }

    fun onLaunchTrackingClicked() {
        screen?.openLaunchTrackingScreen()
    }

    fun onUpcomingLaunchesClicked() {
        screen?.openUpcomingLaunchesScreen()
    }
}