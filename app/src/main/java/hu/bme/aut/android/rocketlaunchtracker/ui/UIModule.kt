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
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)

    @Provides
    @Singleton
    fun aboutPresenter(
        aboutInteractor: AboutInteractor
    ) = AboutPresenter(aboutInteractor)

    @Provides
    @Singleton
    fun launchTrackingPresenter(
        executor: Executor,
        launchDetailsInteractor: LaunchDetailsInteractor
    ) = LaunchTrackingPresenter(executor, launchDetailsInteractor)

    @Provides
    @Singleton
    fun upcomingLaunchesPresenter(
        executor: Executor,
        launchesInteractor: LaunchesInteractor
    ) = UpcomingLaunchesPresenter(executor, launchesInteractor)
}