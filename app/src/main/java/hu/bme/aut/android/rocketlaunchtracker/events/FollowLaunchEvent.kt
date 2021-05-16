package hu.bme.aut.android.rocketlaunchtracker.events

data class FollowLaunchEvent(
    val isFollowed: Boolean,
    val throwable: Throwable? = null
)