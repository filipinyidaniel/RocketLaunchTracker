package hu.bme.aut.android.rocketlaunchtracker.events

import hu.bme.aut.android.rocketlaunchtracker.model.LaunchDetails

data class GetLaunchDetailsEvent(
    val launchDetails: LaunchDetails?,
    val isFollowed: Boolean,
    val throwable: Throwable? = null
)
