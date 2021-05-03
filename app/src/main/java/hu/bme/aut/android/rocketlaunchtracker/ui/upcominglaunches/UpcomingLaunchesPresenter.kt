package hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches

import hu.bme.aut.android.rocketlaunchtracker.events.GetLaunchesEvent
import hu.bme.aut.android.rocketlaunchtracker.interactor.launches.LaunchesInteractor
import hu.bme.aut.android.rocketlaunchtracker.model.Launch
import hu.bme.aut.android.rocketlaunchtracker.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class UpcomingLaunchesPresenter @Inject constructor(
    private val executor: Executor,
    private val launchesInteractor: LaunchesInteractor
) : Presenter<UpcomingLaunchesScreen>() {

    override fun attachScreen(screen: UpcomingLaunchesScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun onLoad() {
        executor.execute {
            launchesInteractor.getUpcomingLaunches()
        }
    }

    fun onLaunchSelected(id: String) {
        screen?.openLaunchTrackingScreen(id)
    }

    fun onLaunchTrackingClicked() {
        screen?.openLaunchTrackingScreen(null)
    }

    fun onAboutClicked() {
        screen?.openAboutScreen()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetLaunchesEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            screen?.showErrorMessage(event.throwable?.message.orEmpty())
        } else if (event.launches != null) {
            screen?.showLaunches(event.launches as MutableList<Launch>)
        }
    }
}