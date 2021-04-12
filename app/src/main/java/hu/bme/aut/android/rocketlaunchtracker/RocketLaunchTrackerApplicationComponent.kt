package hu.bme.aut.android.rocketlaunchtracker

import dagger.Component
import hu.bme.aut.android.rocketlaunchtracker.interactor.InteractorModule
import hu.bme.aut.android.rocketlaunchtracker.ui.UIModule
import hu.bme.aut.android.rocketlaunchtracker.ui.about.AboutActivity
import hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking.LaunchTrackingActivity
import hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches.UpcomingLaunchesActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, InteractorModule::class])
interface RocketLaunchTrackerApplicationComponent {
    fun inject(aboutActivity: AboutActivity)
    fun inject(launchTrackingActivity: LaunchTrackingActivity)
    fun inject(upcomingLaunchesActivity: UpcomingLaunchesActivity)
}