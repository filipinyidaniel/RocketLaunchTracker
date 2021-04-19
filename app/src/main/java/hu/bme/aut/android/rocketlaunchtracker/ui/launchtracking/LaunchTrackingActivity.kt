package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.android.rocketlaunchtracker.R
import hu.bme.aut.android.rocketlaunchtracker.RocketLaunchTrackerApplication
import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails
import javax.inject.Inject

class LaunchTrackingActivity : AppCompatActivity(), LaunchTrackingScreen {

    @Inject
    lateinit var launchTrackingPresenter: LaunchTrackingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_tracking)
        (application as RocketLaunchTrackerApplication).injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        launchTrackingPresenter.attachScreen(this)
    }

    override fun onStop() {
        launchTrackingPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        launchTrackingPresenter.loadLaunchDetails("73ae8553-cc90-46e9-9a01-70a712493856")
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