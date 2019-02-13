package com.umut.demoflickrapp.network.Service

import com.umut.demoflickrapp.Model.PhotosParent
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


class RecentPhotosRestApi {
    interface GetRecentImages {
        @GET("?&method=flickr.photos.getRecent")
        fun getRecentImagesResult(
            @Query("api_key") apiKey: String, @Query("format") format: String, @Query("nojsoncallback") noJsonCallback: Int,
            @Query("per_page") perPage: Int, @Query("page") page: Int
        ): Call<PhotosParent>
    }
}
