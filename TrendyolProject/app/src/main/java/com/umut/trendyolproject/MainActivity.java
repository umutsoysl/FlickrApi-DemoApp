package com.umut.trendyolproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.umut.trendyolproject.adapter.PhotosAdapter;
import com.umut.trendyolproject.model.ContentModel;
import com.umut.trendyolproject.model.TitleModel;
import com.umut.trendyolproject.service.ApiService;
import com.umut.trendyolproject.service.RetroClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;


public class MainActivity extends Activity
{
    ProgressDialog pDialog;
    private List<ContentModel> photosList;
    RecyclerView photoList;
    PhotosAdapter photosAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photoList = (RecyclerView) findViewById(R.id.photoList);

        ApiService api = RetroClient.getApiService();

        Call<TitleModel> call = api.getAllPhotos();

        pDialog = new ProgressDialog(getApplicationContext());

        call.enqueue(new Callback<TitleModel>() {
            @Override
            public void onResponse(Call<TitleModel> call, Response<TitleModel> response) {
                //Dismiss Dialog
                pDialog.dismiss();

                if (response.isSuccessful()) {

                    photosList = response.body().getPhoto();

                    photosAdapter = new PhotosAdapter(MainActivity.this,photosList);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    photoList.setLayoutManager(mLayoutManager);
                    photoList.setItemAnimator(new DefaultItemAnimator());
                    photoList.setAdapter(photosAdapter);

                }
            }

            @Override
            public void onFailure(Call<TitleModel> call, Throwable t) {
                pDialog.dismiss();
            }
        });

    }

}
