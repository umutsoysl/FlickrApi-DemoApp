package com.umut.demoflickrapp.network.Service

import android.util.Log
import com.squareup.otto.Bus
import com.squareup.otto.Subscribe
import com.umut.demoflickrapp.network.AppEvent.ApiError
import com.umut.demoflickrapp.network.AppEvent.AppEvents
import com.umut.demoflickrapp.Model.PhotoInfoParent
import com.umut.demoflickrapp.Model.PhotosParent
import com.umut.demoflickrapp.ui.Activity.PhotoGalery
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PhotoService(
    private val mBus: Bus,
    private val searchImageRestApi: SearchPhotosRestApi.GetSearchResult,
    private val recentImagesRestApi: RecentPhotosRestApi.GetRecentImages,
    private val photoInfoRestApi: PhotoInfoRestApi.GetPhotoInfo
) {
    private val TAG = "AuthService"

    @Subscribe
    fun getSearchedImages(event: AppEvents.SearchImageRequest) {
        searchImageRestApi.getSearchImagesResults(
            PhotoGalery.API_KEY,
            "json",
            1,
            event.query,
            event.perPage,
            event.page
        ).enqueue(object :
            Callback<PhotosParent> {
            override fun onResponse(call: Call<PhotosParent>, response: Response<PhotosParent>) {
                Log.d(
                    TAG,
                    "ON RESPONSE search photo: " + response.isSuccessful() + " - responsecode: " + response.code() + " - response:" + response.message()
                )
                Log.d(TAG, "CALL URL : " + call.request().url())
                if (response.isSuccessful()) {
                    mBus.post(AppEvents.SearchImageResponse(response))
                } else {
                    mBus.post(ApiError(response.code(), ""))
                }
            }

            override fun onFailure(call: Call<PhotosParent>, t: Throwable) {
                Log.d(TAG, "ON FAILURE: " + t.message)
                t.printStackTrace()
                mBus.post(ApiError())
            }
        })
    }

    @Subscribe
    fun getRecentImages(event: AppEvents.RecentImagesRequest) {
        recentImagesRestApi.getRecentImagesResult(PhotoGalery.API_KEY, "json", 1, event.perPage, event.page)
            .enqueue(object :
                Callback<PhotosParent> {
                override fun onResponse(call: Call<PhotosParent>, response: Response<PhotosParent>) {
                    Log.d(
                        TAG,
                        "ON RESPONSE recent photos: " + response.isSuccessful() + " - responsecode: " + response.code() + " - response:" + response.message()
                    )
                    Log.d(TAG, "CALL URL : " + call.request().url())
                    if (response.isSuccessful()) {
                        mBus.post(AppEvents.RecentImagesResponse(response))
                    } else {
                        mBus.post(ApiError(response.code(), ""))
                    }
                }

                override fun onFailure(call: Call<PhotosParent>, t: Throwable) {
                    Log.d(TAG, "ON FAILURE: " + t.message)
                    t.printStackTrace()
                    mBus.post(ApiError())
                }
            })
    }

    @Subscribe
    fun getPhotoInfo(event: AppEvents.PhotoInfoRequest) {
        Log.d(TAG, "SERVICE PHOTO ID: " + event.photoId)
        photoInfoRestApi.getPhotoInfo(PhotoGalery.API_KEY, "json", 1, event.photoId).enqueue(object :
            Callback<PhotoInfoParent> {
            override fun onResponse(call: Call<PhotoInfoParent>, response: Response<PhotoInfoParent>) {
                Log.d(
                    TAG,
                    "ON RESPONSE photoInfo: " + response.isSuccessful() + " - responsecode: " + response.code() + " - response:" + response.message()
                )
                Log.d(TAG, "CALL URL : " + call.request().url())
                if (response.isSuccessful()) {
                    mBus.post(AppEvents.PhotoInfoResponse(response))
                } else {
                    mBus.post(ApiError(response.code(), ""))
                }
            }

            override fun onFailure(call: Call<PhotoInfoParent>, t: Throwable) {
                Log.d(TAG, "ON FAILURE: " + t.message)
                t.printStackTrace()
                mBus.post(ApiError())
            }
        })
    }
}
