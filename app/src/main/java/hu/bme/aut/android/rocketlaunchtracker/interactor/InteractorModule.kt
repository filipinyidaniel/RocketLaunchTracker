package hu.bme.aut.android.rocketlaunchtracker.interactor

import dagger.Module
import dagger.Provides
import hu.bme.aut.android.rocketlaunchtracker.database.LaunchDetailsDAO
import hu.bme.aut.android.rocketlaunchtracker.interactor.launchdetails.LaunchDetailsInteractor
import hu.bme.aut.android.rocketlaunchtracker.interactor.launches.LaunchesInteractor
import hu.bme.aut.android.rocketlaunchtracker.network.apis.LaunchApi
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideLaunchDetailsInteractor(
        launchApi: LaunchApi,
        launchDetailsDAO: LaunchDetailsDAO
    ) = LaunchDetailsInteractor(launchApi, launchDetailsDAO)

    @Provides
    @Singleton
    fun provideLaunchesInteractor(
        launchApi: LaunchApi
    ) = LaunchesInteractor(launchApi)

}