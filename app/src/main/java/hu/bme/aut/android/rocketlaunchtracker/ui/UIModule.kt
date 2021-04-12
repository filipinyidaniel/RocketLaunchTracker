package hu.bme.aut.android.rocketlaunchtracker.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.aut.android.rocketlaunchtracker.interactor.about.AboutInteractor
import hu.bme.aut.android.rocketlaunchtracker.interactor.launchdetails.LaunchDetailsInteractor
import hu.bme.aut.android.rocketlaunchtracker.interactor.launches.LaunchesInteractor
import hu.bme.aut.android.rocketlaunchtracker.ui.about.AboutPresenter
import hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking.LaunchTrackingPresenter
import hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches.UpcomingLaunchesPresenter
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun aboutPresenter(aboutInteractor: AboutInteractor) = AboutPresenter(aboutInteractor)

    @Provides
    @Singleton
    fun launchTrackingPresenter(launchDetailsInteractor: LaunchDetailsInteractor) = LaunchTrackingPresenter(launchDetailsInteractor)

    @Provides
    @Singleton
    fun upcomingLaunchesPresenter(launchesInteractor: LaunchesInteractor) = UpcomingLaunchesPresenter(launchesInteractor)
}