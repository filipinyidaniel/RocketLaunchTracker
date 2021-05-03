package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import android.content.Intent
import android.net.Uri
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
import java.text.SimpleDateFormat
import javax.inject.Inject

class LaunchTrackingActivity : AppCompatActivity(), LaunchTrackingScreen {
    companion object {
        const val KEY_LAUNCH_ID = "KEY_LAUNCH_ID"
    }

    @Inject
    lateinit var launchTrackingPresenter: LaunchTrackingPresenter

    private val dateFormat = SimpleDateFormat("MM/dd/yyyy h:mm")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_tracking)
        setupNavigationMenu()
        setupButtons()
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

        navigationView.setCheckedItem(R.id.launch_tracking)
        navigationView.setNavigationItemSelectedListener { item ->
            navigationDrawer.closeDrawer(GravityCompat.START)
            when (item.itemId) {
                R.id.upcoming_launches -> {
                    launchTrackingPresenter.onUpcomingLaunchesClicked()
                    true
                }
                R.id.about -> {
                    launchTrackingPresenter.onAboutClicked()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun setupButtons() {
        btnWebsite.setOnClickListener { launchTrackingPresenter.onWebsiteClicked() }
        btnVideo.setOnClickListener { launchTrackingPresenter.onVideoClicked() }
    }

    override fun onStart() {
        super.onStart()
        launchTrackingPresenter.attachScreen(this)
        val launchId = intent.getStringExtra(KEY_LAUNCH_ID)
        launchTrackingPresenter.onLoad(launchId)
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
        tvRocket.text = details.rocket
        tvProvider.text = details.serviceProvider
        tvMission.text = details.mission
        tvMissionDescription.text = details.missionDescription
        tvStatus.text = details.status
        tvDateTime.text = if (details.palnnedDate == null) "SOON" else dateFormat.format(details.palnnedDate)
        tvLocation.text = details.location
    }

    override fun enableWebsiteButton() {
        btnWebsite.isEnabled = true
    }

    override fun disableWebsiteButton() {
        btnWebsite.isEnabled = false
    }

    override fun enableVideoButton() {
        btnVideo.isEnabled = true
    }

    override fun disableVideoButton() {
        btnVideo.isEnabled = false
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

    override fun openURL(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun openUpcomingLaunchesScreen() {
        val intent = Intent(this, UpcomingLaunchesActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun openAboutScreen() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }
}