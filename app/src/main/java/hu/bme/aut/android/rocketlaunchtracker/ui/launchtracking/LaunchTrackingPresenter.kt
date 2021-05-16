package hu.bme.aut.android.rocketlaunchtracker.ui.launchtracking

import hu.bme.aut.android.rocketlaunchtracker.events.FollowLaunchEvent
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
        screen?.showProgressBar()
        executor.execute {
            launchDetailsInteractor.getLaunchDetails(id)
        }
    }

    fun onFollowClicked() {
        var details = launchDetails
        if (details != null) {
            executor.execute {
                launchDetailsInteractor.followLaunch(details)
            }
        }
    }

    fun onUnfollowClicked() {
        var details = launchDetails
        if (details != null) {
            executor.execute {
                launchDetailsInteractor.unfollowLaunch(details)
            }
        }
    }

    fun onWebsiteClicked() {
        var url = launchDetails?.infoURL
        if (!url.isNullOrEmpty()) {
            screen?.openURL(url)
        }
    }

    fun onVideoClicked() {
        var url = launchDetails?.videoURL
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
    fun onGetLaunchDetailsEvent(event: GetLaunchDetailsEvent) {
        screen?.hideProgressBar()
        if (event.throwable != null) {
            event.throwable.printStackTrace()
            screen?.showMessage("Could not load launch details!")
        } else if (event.launchDetails != null) {
            launchDetails = event.launchDetails
            screen?.showLaunchDetails(event.launchDetails)
            if (event.isFollowed) {
                screen?.hideFollowButton()
                screen?.showUnfollowButton()
            } else {
                screen?.showFollowButton()
                screen?.hideUnfollowButton()
            }
        } else {
            screen?.hideFollowButton()
            screen?.hideUnfollowButton()
            screen?.showMessage("No followed launches!")
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFollowLaunchEvent(event: FollowLaunchEvent) {
        if (event.throwable != null) {
            event.throwable.printStackTrace()
            screen?.showMessage("Could not save to local database!")
        } else {
            if (event.isFollowed) {
                screen?.hideFollowButton()
                screen?.showUnfollowButton()
            } else {
                screen?.showFollowButton()
                screen?.hideUnfollowButton()
            }
        }
    }
}
