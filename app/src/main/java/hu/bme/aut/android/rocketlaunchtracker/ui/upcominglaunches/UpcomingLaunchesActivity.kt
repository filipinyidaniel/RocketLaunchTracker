package hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import hu.bme.aut.android.rocketlaunchtracker.R
import hu.bme.aut.android.rocketlaunchtracker.RocketLaunchTrackerApplication
import hu.bme.aut.android.rocketlaunchtracker.model.Launch
import hu.bme.aut.android.rocketlaunchtracker.ui.about.AboutActivity
import hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking.LaunchTrackingActivity
import kotlinx.android.synthetic.main.activity_upcoming_launches.*
import javax.inject.Inject

class UpcomingLaunchesActivity : AppCompatActivity(), UpcomingLaunchesScreen {

    private val displayedLaunches: MutableList<Launch> = mutableListOf()
    private var launchAdapter: LaunchAdapter? = null

    @Inject
    lateinit var upcomingLaunchesPresenter: UpcomingLaunchesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upcoming_launches)
        setupToolbar()
        (application as RocketLaunchTrackerApplication).injector.inject(this)
        setupList()
    }

    private fun setupToolbar() {
        val toggle = ActionBarDrawerToggle(
            this,
            navigationDrawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        navigationDrawer.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setCheckedItem(R.id.upcoming_launches)
        navigationView.setNavigationItemSelectedListener { item ->
            navigationDrawer.closeDrawer(GravityCompat.START)
            when (item.itemId) {
                R.id.launch_tracking -> {
                    upcomingLaunchesPresenter.onLaunchTrackingClicked()
                    true
                }
                R.id.about -> {
                    upcomingLaunchesPresenter.onAboutClicked()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun setupList() {
        launchAdapter = LaunchAdapter(this, upcomingLaunchesPresenter, displayedLaunches)
        listLaunches.adapter = launchAdapter
    }

    override fun onStart() {
        super.onStart()
        upcomingLaunchesPresenter.attachScreen(this)
        upcomingLaunchesPresenter.onLoad()
    }

    override fun onStop() {
        upcomingLaunchesPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        navigationView.setCheckedItem(R.id.upcoming_launches)
    }

    override fun onBackPressed() {
        if (navigationDrawer.isDrawerOpen(GravityCompat.START)) {
            navigationDrawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun showLaunches(launches: List<Launch>) {
        tvMessage.visibility = View.GONE
        listLaunches.visibility = View.VISIBLE
        displayedLaunches.clear()
        if (launches != null) {
            displayedLaunches.addAll(launches)
        }
        launchAdapter?.notifyDataSetChanged()
    }

    override fun showProgressBar() {
        listLaunches.visibility = View.GONE
        tvMessage.visibility = View.GONE
        progressBar.progress = 0
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun showMessage(message: String) {
        listLaunches.visibility = View.GONE
        tvMessage.visibility = View.VISIBLE
        tvMessage.text = message
    }

    override fun openLaunchTrackingScreen(id: String?) {
        val intent = Intent(this, LaunchTrackingActivity::class.java)
        if (id != null) {
            intent.putExtra(LaunchTrackingActivity.KEY_LAUNCH_ID, id)
        } else {
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
    }

    override fun openAboutScreen() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }
}