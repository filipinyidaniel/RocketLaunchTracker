package hu.bme.aut.android.rocketlaunchtracker.events

import hu.bme.aut.android.rocketlaunchtracker.model.Launch

data class GetLaunchesEvent(
    var launches: List<Launch>? = null,
    var throwable: Throwable? = null
)
