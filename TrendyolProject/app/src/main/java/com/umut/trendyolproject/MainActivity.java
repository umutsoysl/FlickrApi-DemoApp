package com.umut.trendyolproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.umut.trendyolproject.adapter.PhotosAdapter;
import com.umut.trendyolproject.model.FlickrResult;
import com.umut.trendyolproject.model.PhotosModel;
import com.umut.trendyolproject.service.ApiService;
import com.umut.trendyolproject.service.RetroClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;


public class MainActivity extends Activity
{
    ProgressDialog pDialog;
    private List<PhotosModel> photosList;
    RecyclerView photoList;
    PhotosAdapter photosAdapter;
    public static String ACCESSTOKEN = "2157705024901861-780e0afb33f61967";
    public static String METHOD = "flickr.photos.getRecent";
    public static String APIKEY = "b8ab4d0b8904bab60c3d9b20ea0a3133";
    public static String FORMAT = "json";
    public static String APISECRET = "ced23bbd4bdb964f016e4756ee1fcece";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photoList = (RecyclerView) findViewById(R.id.photoList);

        ApiService api = RetroClient.getApiService();

        Call<FlickrResult> call = api.getPhotos(METHOD,APIKEY,FORMAT,"1",ACCESSTOKEN,APISECRET);

        pDialog = new ProgressDialog(getApplicationContext());
        Log.w("request",call.request().toString());
        call.enqueue(new Callback<FlickrResult>() {
            @Override
            public void onResponse(Call<FlickrResult> call, Response<FlickrResult> response) {
                //Dismiss Dialog
                pDialog.dismiss();

                if (response.isSuccessful()) {

                    photosList = response.body().photos.photo;

                    photosAdapter = new PhotosAdapter(MainActivity.this,photosList);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    photoList.setLayoutManager(mLayoutManager);
                    photoList.setItemAnimator(new DefaultItemAnimator());
                    photoList.setAdapter(photosAdapter);

                }
            }

            @Override
            public void onFailure(Call<FlickrResult> call, Throwable t) {
                pDialog.dismiss();
            }
        });

    }

}
