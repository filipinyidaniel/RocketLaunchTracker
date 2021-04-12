package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.android.rocketlaunchtracker.R
import hu.bme.aut.android.rocketlaunchtracker.models.LaunchDetails

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

    override fun showLaunchDetails(details: LaunchDetails) {
        TODO("Not yet implemented")
    }

    override fun enableWebsiteButton() {
        TODO("Not yet implemented")
    }

    override fun disableWebsiteButton() {
        TODO("Not yet implemented")
    }

    override fun enableVideoButton() {
        TODO("Not yet implemented")
    }

    override fun disableVideoButton() {
        TODO("Not yet implemented")
    }

    override fun showFollowButton() {
        TODO("Not yet implemented")
    }

    override fun hideFollowButton() {
        TODO("Not yet implemented")
    }

    override fun showUnfollowButton() {
        TODO("Not yet implemented")
    }

    override fun hideUnfollowButton() {
        TODO("Not yet implemented")
    }

    override fun showNoTracking() {
        TODO("Not yet implemented")
    }

    override fun showInfoMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun showErrorMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun goToURL(url: String) {
        TODO("Not yet implemented")
    }

    override fun goToUpcomingLaunchesScreen() {
        TODO("Not yet implemented")
    }

    override fun goToAboutScreen() {
        TODO("Not yet implemented")
    }
}