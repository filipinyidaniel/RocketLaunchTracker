package hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.android.rocketlaunchtracker.R

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
}