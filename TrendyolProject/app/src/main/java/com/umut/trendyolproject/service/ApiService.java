package com.umut.trendyolproject.service;

import com.umut.trendyolproject.model.FlickrResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {

    @GET("services/rest/")
    Call<FlickrResult> getPhotos(@Query("method") String method,
                                 @Query("api_key") String apiKey,
                                 @Query("format") String format,
                                 @Query("nojsoncallback") String nojsoncallback,
                                 @Query("auth_token") String auth_token,
                                 @Query("api_sig") String api_sig);

    @GET("services/rest/")
    Call<FlickrResult> searchPhotos(@Query("method") String method,
                                    @Query("api_key") String apiKey,
                                    @Query("tags") String tags,
                                    @Query("format") String format,
                                    @Query("nojsoncallback") String nojsoncallback,
                                    @Query("auth_token") String auth_token,
                                    @Query("api_sig") String api_sig);

}