package com.umut.demoflickrapp.network.Service

import com.umut.demoflickrapp.Model.PhotosParent
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


class SearchPhotosRestApi {

    interface GetSearchResult {
        @GET("?&method=flickr.photos.search")//("?&method=flickr.photos.getRecent") //
        fun getSearchImagesResults(
            @Query("api_key") apiKey: String, @Query("format") format: String, @Query("nojsoncallback") noJsonCallback: Int,
            @Query("text") text: String, @Query("per_page") perPage: Int, @Query("page") page: Int
        ): Call<PhotosParent>
    }
}
