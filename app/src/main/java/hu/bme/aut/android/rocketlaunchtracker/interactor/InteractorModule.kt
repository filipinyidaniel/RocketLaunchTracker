package hu.bme.aut.android.rocketlaunchtracker.interactor

import dagger.Module
import dagger.Provides
import hu.bme.aut.android.rocketlaunchtracker.interactor.about.AboutInteractor
import hu.bme.aut.android.rocketlaunchtracker.interactor.launchdetails.LaunchDetailsInteractor
import hu.bme.aut.android.rocketlaunchtracker.interactor.launches.LaunchesInteractor
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideAboutInteractor() = AboutInteractor()

    @Provides
    @Singleton
    fun provideLaunchDetailsInteractor() = LaunchDetailsInteractor()

    @Provides
    @Singleton
    fun provideLaunchesInteractor() = LaunchesInteractor()
}