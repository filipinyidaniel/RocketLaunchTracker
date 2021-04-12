package hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.android.rocketlaunchtracker.R
import hu.bme.aut.android.rocketlaunchtracker.model.Launch

class UpcomingLaunchesActivity : AppCompatActivity(), UpcomingLaunchesScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upcoming_launches)
    }

    override fun onStart() {
        super.onStart()
        UpcomingLaunchesPresenter.attachScreen(this)
    }

    override fun onStop() {
        UpcomingLaunchesPresenter.detachScreen()
        super.onStop()
    }

    override fun showLaunches(launches: List<Launch>) {
        TODO("Not yet implemented")
    }

    override fun showErrorMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun goToLaunchTrackingScreen(id: String?) {
        TODO("Not yet implemented")
    }

    override fun goToAboutScreen() {
        TODO("Not yet implemented")
    }
}