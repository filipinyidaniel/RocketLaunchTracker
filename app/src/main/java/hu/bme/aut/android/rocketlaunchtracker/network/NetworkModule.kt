package hu.bme.aut.android.rocketlaunchtracker.network

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hu.bme.aut.android.rocketlaunchtracker.network.apis.LaunchApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideLaunchApi(client: OkHttpClient): LaunchApi {
        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            .create()
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(NetworkConfig.API_ENDPOINT_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(LaunchApi::class.java)
    }

}