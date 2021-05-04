package hu.bme.aut.android.rocketlaunchtracker.events

import hu.bme.aut.android.rocketlaunchtracker.model.Launch

data class GetLaunchesEvent(
    val launches: List<Launch>?,
    val throwable: Throwable? = null
)
