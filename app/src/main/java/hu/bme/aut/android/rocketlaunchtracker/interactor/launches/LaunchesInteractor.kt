package hu.bme.aut.android.rocketlaunchtracker.interactor.launches

import android.util.Log
import hu.bme.aut.android.rocketlaunchtracker.events.GetLaunchesEvent
import hu.bme.aut.android.rocketlaunchtracker.model.Launch
import hu.bme.aut.android.rocketlaunchtracker.network.apis.LaunchApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class LaunchesInteractor @Inject constructor(private var launchApi: LaunchApi) {
    fun getUpcomingLaunches() {
        try {
            var launchListCall = launchApi.getUpcomingLaunches(null, null, null)

            val response = launchListCall.execute()
            var body = response.body()
            Log.d("Reponse", body.toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }

            var result = mutableListOf<Launch>()
            if (body != null) {
                for (launchSerializerCommon in body.results) {
                    var launch = Launch(
                        launchSerializerCommon.id.toString(),
                        launchSerializerCommon.rocket?.configuration?.full_name.orEmpty(),
                        launchSerializerCommon.launch_service_provider?.name.orEmpty(),
                        launchSerializerCommon.mission?.name.orEmpty(),
                        launchSerializerCommon.net,
                        launchSerializerCommon.status?.name.orEmpty()
                    )
                    result.add(launch)
                }
            }

            EventBus.getDefault().post(GetLaunchesEvent(result, null))
        } catch (e: Exception) {
            EventBus.getDefault().post(GetLaunchesEvent(null, e))
        }
    }
}