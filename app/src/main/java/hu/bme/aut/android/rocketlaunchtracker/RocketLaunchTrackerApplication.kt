package hu.bme.aut.android.rocketlaunchtracker

import android.app.Application
import hu.bme.aut.android.rocketlaunchtracker.ui.UIModule

class RocketLaunchTrackerApplication : Application() {
    lateinit var injector: RocketLaunchTrackerApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerRocketLaunchTrackerApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}