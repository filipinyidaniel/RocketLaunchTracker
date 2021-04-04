package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.android.rocketlaunchtracker.R

class LaunchTrackingActivity : AppCompatActivity(), LaunchTrackingScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_tracking)
    }

    override fun onStart() {
        super.onStart()
        LaunchTrackingPresenter.attachScreen(this)
    }

    override fun onStop() {
        LaunchTrackingPresenter.detachScreen()
        super.onStop()
    }
}