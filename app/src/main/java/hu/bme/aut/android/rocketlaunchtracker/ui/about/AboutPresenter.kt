package hu.bme.aut.android.rocketlaunchtracker.ui.about

import hu.bme.aut.android.rocketlaunchtracker.ui.Presenter
import javax.inject.Inject

class AboutPresenter @Inject constructor(
) : Presenter<AboutScreen?>() {

    fun onLoad() {
        screen?.showAppInfo()
    }

    fun onLaunchTrackingClicked() {
        screen?.openLaunchTrackingScreen()
    }

    fun onUpcomingLaunchesClicked() {
        screen?.openUpcomingLaunchesScreen()
    }
}