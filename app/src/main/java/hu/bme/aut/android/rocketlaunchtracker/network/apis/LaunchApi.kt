package hu.bme.aut.android.rocketlaunchtracker.network.apis

import hu.bme.aut.android.rocketlaunchtracker.network.models.LaunchDetailed
import hu.bme.aut.android.rocketlaunchtracker.network.models.LaunchList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface LaunchApi {

    /**
     *
     * API endpoint that returns future Launch objects and launches from the last twenty four hours.
     * @param status
     * @param limit Number of results to return per page.
     * @param offset The initial index from which to return the results.
     * @return Call<LaunchList>
    </LaunchList> */
    @Headers("Accept: application/json")
    @GET("launch/upcoming/")
    fun getUpcomingLaunches(
        @Query("status") status: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Call<LaunchList>


    /**
     * API endpoint that returns all Launch objects or a single launch.
     * @param id
     * @return Call<LaunchDetailed>
    </LaunchDetailed> */
    @Headers("Accept: application/json")
    @GET("launch/{id}/")
    fun getLaunch(
            @Path("id") id: String?
    ): Call<LaunchDetailed>

}
