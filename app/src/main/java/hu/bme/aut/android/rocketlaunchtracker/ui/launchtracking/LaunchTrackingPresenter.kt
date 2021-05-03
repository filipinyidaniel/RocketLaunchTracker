package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import hu.bme.aut.android.rocketlaunchtracker.interactor.launchdetails.LaunchDetailsInteractor
import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails
import hu.bme.aut.android.rocketlaunchtracker.ui.Presenter
import java.util.*
import java.util.concurrent.Executor
import javax.inject.Inject

class LaunchTrackingPresenter @Inject constructor(
    private val executor: Executor,
    private val launchDetailsInteractor: LaunchDetailsInteractor
) : Presenter<LaunchTrackingScreen?>() {

    private var launchDetails: LaunchDetails? = null

    fun onLoad(id: String?) {
        executor.execute {
            if (id != null) {
                //launchDetailsInteractor.getLaunchDetails(id)
            }
        }

        launchDetails = LaunchDetails(
            "gaejagjkeéjklaegéjkl",
            "Falcon 9 Block 5",
            "Space X",
            "Starlink 21",
            "A batch of 60 satellites for Starlink mega-constellation - SpaceX's project for space-based Internet communication system.",
            Date(),
            "Kennedy Space Center, FL, USA",
            "SUCCESS",
            "https://google.com",
            ""
        )

        if (launchDetails != null) {
            var details = launchDetails as LaunchDetails
            screen?.showLaunchDetails(details)
            if (details.infoURL.isNullOrEmpty()) {
                screen?.disableWebsiteButton()
            } else {
                screen?.enableWebsiteButton()
            }
            if (details.videoURL.isNullOrEmpty()) {
                screen?.disableVideoButton()
            } else {
                screen?.enableVideoButton()
            }
        } else {
            screen?.showNoTracking()
            screen?.hideFollowButton()
            screen?.hideUnfollowButton()
        }
    }

    fun onFollowClicked() {
        TODO("Not yet implemented")
    }

    fun onUnfollowClicked() {
        TODO("Not yet implemented")
    }

    fun onWebsiteClicked() {
        var url = launchDetails?.infoURL
        if (!url.isNullOrEmpty()) {
            screen?.openURL(url)
        }
    }

    fun onVideoClicked() {
        var url = launchDetails?.infoURL
        if (!url.isNullOrEmpty()) {
            screen?.openURL(url)
        }
    }

    fun onUpcomingLaunchesClicked() {
        screen?.openUpcomingLaunchesScreen()
    }

    fun onAboutClicked() {
        screen?.openAboutScreen()
    }
}
