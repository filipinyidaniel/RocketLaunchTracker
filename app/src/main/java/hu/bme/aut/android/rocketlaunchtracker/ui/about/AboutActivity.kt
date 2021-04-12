package hu.bme.aut.android.rocketlaunchtracker.ui.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.android.rocketlaunchtracker.R

class AboutActivity : AppCompatActivity(), AboutScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    override fun onStart() {
        super.onStart()
        AboutPresenter.attachScreen(this)
    }

    override fun onStop() {
        AboutPresenter.detachScreen()
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