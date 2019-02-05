package com.umut.trendyolproject.service;

import com.umut.trendyolproject.model.PhotoInfoModel;
import com.umut.trendyolproject.model.TitleModel;
import retrofit2.Call;
import retrofit2.http.GET;



public interface ApiService {

    @GET("services/rest/?method=flickr.photos.getRecent&api_key=0e643e2fbfda782d581f49f99861bb54&page=1&format=json&nojsoncallback=1&auth_token=72157676256333477-4611ebfc7e2c4381&api_sig=f2193b36bccab78957bd7ca60bc41ae2")
    Call<TitleModel> getAllPhotos();

}