package hu.bme.aut.android.rocketlaunchtracker.interactor.launchdetails

import com.google.gson.GsonBuilder
import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails
import hu.bme.aut.android.rocketlaunchtracker.network.apis.LaunchApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class LaunchDetailsInteractor @Inject constructor(private var launchApi: LaunchApi) {
    fun getLaunchDetails(id: String) : LaunchDetails {
        val launchCall = launchApi.getLaunch(id)

        val response = launchCall.execute()
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        var body = response.body()

        return LaunchDetails(id)
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