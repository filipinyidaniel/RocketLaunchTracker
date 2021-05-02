package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import hu.bme.aut.android.rocketlaunchtracker.R
import hu.bme.aut.android.rocketlaunchtracker.RocketLaunchTrackerApplication
import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails
import javax.inject.Inject

class LaunchTrackingActivity : AppCompatActivity(), LaunchTrackingScreen {

    @Inject
    lateinit var launchTrackingPresenter: LaunchTrackingPresenter

    lateinit var navigationDrawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_tracking)

        navigationDrawer = findViewById<DrawerLayout>(R.id.navigation_drawer)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val toggle = ActionBarDrawerToggle(
            this,
            navigationDrawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        navigationDrawer.addDrawerListener(toggle)
        toggle.syncState()

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

    override fun onBackPressed() {
        if (navigationDrawer.isDrawerOpen(GravityCompat.START)) {
            navigationDrawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
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