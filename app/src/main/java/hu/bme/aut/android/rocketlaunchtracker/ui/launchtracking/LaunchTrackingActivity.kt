package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import hu.bme.aut.android.rocketlaunchtracker.R
import hu.bme.aut.android.rocketlaunchtracker.RocketLaunchTrackerApplication
import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails
import hu.bme.aut.android.rocketlaunchtracker.ui.about.AboutActivity
import hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches.UpcomingLaunchesActivity
import kotlinx.android.synthetic.main.activity_launch_tracking.*
import javax.inject.Inject

class LaunchTrackingActivity : AppCompatActivity(), LaunchTrackingScreen {
    companion object {
        const val KEY_LAUNCH_ID = "KEY_LAUNCH_ID"
    }

    @Inject
    lateinit var launchTrackingPresenter: LaunchTrackingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_tracking)
        setupNavigationMenu()
        (application as RocketLaunchTrackerApplication).injector.inject(this)
    }

    private fun setupNavigationMenu() {
        val toggle = ActionBarDrawerToggle(
            this,
            navigationDrawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        navigationDrawer.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener { item ->
            navigationDrawer.closeDrawer(GravityCompat.START)
            when (item.itemId) {
                R.id.upcoming_launches -> {
                    launchTrackingPresenter.openUpcomingLaunches()
                    true
                }
                R.id.about -> {
                    launchTrackingPresenter.openAbout()
                    true
                }
                else -> {
                    false
                }
            }
        }
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
        navigationView.setCheckedItem(R.id.launch_tracking)
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
        val intent = Intent(this, UpcomingLaunchesActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun goToAboutScreen() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }
}