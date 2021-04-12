package hu.bme.aut.android.rocketlaunchtracker.ui.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.android.rocketlaunchtracker.R
import hu.bme.aut.android.rocketlaunchtracker.RocketLaunchTrackerApplication
import javax.inject.Inject

class AboutActivity : AppCompatActivity(), AboutScreen {

    @Inject
    lateinit var aboutPresenter: AboutPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        (application as RocketLaunchTrackerApplication).injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        aboutPresenter.attachScreen(this)
    }

    override fun onStop() {
        aboutPresenter.detachScreen()
        super.onStop()
    }

    override fun showAppInfo(appVersion: String, copyright: String) {
        TODO("Not yet implemented")
    }

    override fun goToLaunchTrackingScreen() {
        TODO("Not yet implemented")
    }

    override fun goToUpcomingLaunchesScreen() {
        TODO("Not yet implemented")
    }
}