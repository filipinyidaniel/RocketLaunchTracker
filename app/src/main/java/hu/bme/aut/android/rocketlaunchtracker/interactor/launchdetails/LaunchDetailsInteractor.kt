package hu.bme.aut.android.rocketlaunchtracker.interactor.launchdetails

import android.util.Log
import hu.bme.aut.android.rocketlaunchtracker.events.GetLaunchDetailsEvent
import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails
import hu.bme.aut.android.rocketlaunchtracker.network.apis.LaunchApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class LaunchDetailsInteractor @Inject constructor(private var launchApi: LaunchApi) {
    fun getLaunchDetails(id: String?) {
        var event = executeGetLaunchDetails(id)
        EventBus.getDefault().post(event)
    }

    private fun executeGetLaunchDetails(id: String?) : GetLaunchDetailsEvent {
        try {
            var launchFromDB = getLaunchFromDB(id)

            var requestedId = if (id.isNullOrEmpty()) launchFromDB?.id else id
            if (requestedId == null) {
                return GetLaunchDetailsEvent(null, false)
            }

            var launchFromWS = getLaunchFromWS(requestedId)

            if (launchFromWS != null) {
                return if (launchFromDB != null) {
                    saveLaunchToDB(launchFromWS)
                    GetLaunchDetailsEvent(launchFromWS, true)
                } else {
                    GetLaunchDetailsEvent(launchFromWS, false)
                }
            }

            if (launchFromDB != null) {
                return GetLaunchDetailsEvent(launchFromDB, true)
            } else {
                throw Exception("Could not load launch details")
            }
        } catch (e: Exception) {
            return GetLaunchDetailsEvent(null, false, e)
        }
    }

    private fun getLaunchFromDB(id: String?): LaunchDetails? {
        return null
    }

    private fun saveLaunchToDB(launch: LaunchDetails) {
    }

    private fun getLaunchFromWS(id: String): LaunchDetails? {
        try {
            val launchCall = launchApi.getLaunch(id)

            val response = launchCall.execute()
            var body = response.body()
            Log.d("Reponse", body.toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            if (body == null) {
                throw Exception("Could not parse response")
            }

            var result = LaunchDetails(
                body.id.toString(),
                body.rocket?.configuration?.full_name.orEmpty(),
                body.launch_service_provider?.name.orEmpty(),
                body.mission?.name.orEmpty(),
                body.mission?.description,
                body.net,
                body.pad?.location?.name,
                body.status?.name.orEmpty(),
                body.infoURLs?.firstOrNull()?.url,
                body.vidURLs?.firstOrNull()?.url
            )
            return result
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

    fun followLaunch(details: LaunchDetails) {
        TODO("Not yet implemented")
    }

    fun unfollowLaunch(id: String) {
        TODO("Not yet implemented")
    }
}