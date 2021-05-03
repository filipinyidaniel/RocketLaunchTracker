package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import hu.bme.aut.android.rocketlaunchtracker.events.GetLaunchDetailsEvent
import hu.bme.aut.android.rocketlaunchtracker.interactor.launchdetails.LaunchDetailsInteractor
import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails
import hu.bme.aut.android.rocketlaunchtracker.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class LaunchTrackingPresenter @Inject constructor(
    private val executor: Executor,
    private val launchDetailsInteractor: LaunchDetailsInteractor
) : Presenter<LaunchTrackingScreen>() {

    private var launchDetails: LaunchDetails? = null

    override fun attachScreen(screen: LaunchTrackingScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun onLoad(id: String?) {
        executor.execute {
            launchDetailsInteractor.getLaunchDetails(id)
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetLaunchDetailsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            screen?.showErrorMessage(event.throwable?.message.orEmpty())
        } else if (event.launchDetails != null) {
            launchDetails = event.launchDetails
            screen?.showLaunchDetails(event.launchDetails)
            if (event.launchDetails.infoURL.isNullOrEmpty()) {
                screen?.disableWebsiteButton()
            } else {
                screen?.enableWebsiteButton()
            }
            if (event.launchDetails.videoURL.isNullOrEmpty()) {
                screen?.disableVideoButton()
            } else {
                screen?.enableVideoButton()
            }
            if (event.isFollowed) {
                screen?.hideFollowButton()
                screen?.showUnfollowButton()
            } else {
                screen?.showFollowButton()
                screen?.hideUnfollowButton()
            }
        } else {
            screen?.showNoTracking()
            screen?.hideFollowButton()
            screen?.hideUnfollowButton()
        }
    }
}
