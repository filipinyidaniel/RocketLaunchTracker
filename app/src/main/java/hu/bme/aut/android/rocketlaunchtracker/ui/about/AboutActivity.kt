package hu.bme.aut.android.rocketlaunchtracker.ui.about

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import hu.bme.aut.android.rocketlaunchtracker.R
import hu.bme.aut.android.rocketlaunchtracker.RocketLaunchTrackerApplication
import hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking.LaunchTrackingActivity
import hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches.UpcomingLaunchesActivity
import kotlinx.android.synthetic.main.activity_launch_tracking.*
import javax.inject.Inject

class AboutActivity : AppCompatActivity(), AboutScreen {

    @Inject
    lateinit var aboutPresenter: AboutPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
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
                R.id.launch_tracking -> {
                    aboutPresenter.openLaunchTracking()
                    true
                }
                R.id.upcoming_launches -> {
                    aboutPresenter.openUpcomingLaunches()
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
        aboutPresenter.attachScreen(this)
    }

    override fun onStop() {
        aboutPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        navigationView.setCheckedItem(R.id.about)
    }

    override fun onBackPressed() {
        if (navigationDrawer.isDrawerOpen(GravityCompat.START)) {
            navigationDrawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun showAppInfo(appVersion: String, copyright: String) {
        TODO("Not yet implemented")
    }

    override fun goToLaunchTrackingScreen() {
        val intent = Intent(this, LaunchTrackingActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun goToUpcomingLaunchesScreen() {
        val intent = Intent(this, UpcomingLaunchesActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}