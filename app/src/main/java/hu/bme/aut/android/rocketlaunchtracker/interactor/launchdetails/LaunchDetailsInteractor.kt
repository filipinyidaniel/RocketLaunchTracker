package hu.bme.aut.android.rocketlaunchtracker.interactor.launchdetails

import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails
import hu.bme.aut.android.rocketlaunchtracker.network.apis.LaunchApi
import javax.inject.Inject


class LaunchDetailsInteractor @Inject constructor(private var launchApi: LaunchApi) {
    fun getLaunchDetails(id: String) : LaunchDetails {
        val launchCall = launchApi.getLaunch(id)

        val response = launchCall.execute()
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        var body = response.body()

        TODO("Not yet implemented")
    }

    fun getFollowedLaunchId() : String? {
        TODO("Not yet implemented")
    }

    fun followLaunch(details: LaunchDetails) {
        TODO("Not yet implemented")
    }

    fun unfollowLaunch(id: String) {
        TODO("Not yet implemented")
    }
}