package com.umut.demoflickrapp.ui.Activity

import android.app.Application
import android.widget.Toast
import com.google.gson.GsonBuilder
import com.squareup.otto.Bus
import com.squareup.otto.Subscribe
import com.squareup.otto.ThreadEnforcer
import com.squareup.picasso.Picasso
import com.umut.demoflickrapp.network.AppEvent.ApiError
import com.umut.demoflickrapp.network.Service.PhotoInfoRestApi
import com.umut.demoflickrapp.network.Service.PhotoService
import com.umut.demoflickrapp.network.Service.RecentPhotosRestApi
import com.umut.demoflickrapp.network.Service.SearchPhotosRestApi
import com.umut.demoflickrapp.Util.Utils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PhotoGalery : Application() {

    val bus: Bus
        get() {
            if (mBus == null) {
                mBus = Bus(ThreadEnforcer.ANY)
            }
            return mBus as Bus
        }

    override fun onCreate() {
        super.onCreate()
        val context = applicationContext
        val retrofit = createRetrofitObject(ROOT_URL)
        bus.register(this)
        bus.register(
            PhotoService(
                bus,
                retrofit.create<SearchPhotosRestApi.GetSearchResult>(SearchPhotosRestApi.GetSearchResult::class.java!!),
                retrofit.create<RecentPhotosRestApi.GetRecentImages>(RecentPhotosRestApi.GetRecentImages::class.java!!),
                retrofit.create<PhotoInfoRestApi.GetPhotoInfo>(PhotoInfoRestApi.GetPhotoInfo::class.java!!)
            )
        )
        val picasso = Picasso.Builder(context)
            .build()
        Picasso.setSingletonInstance(picasso)
    }

    private fun createRetrofitObject(url: String): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Subscribe
    fun onApiError(event: ApiError) {
        if (event.errorMessage == null) {
            if (Utils.isNetworkAvailable(applicationContext)) {
                Toast.makeText(
                    applicationContext,
                    "Something went wrong, please try again" + event.statusCode,
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(applicationContext, "No connection.", Toast.LENGTH_LONG).show()
            }
        } else {
            if (event.statusCode === 401) {
                Toast.makeText(applicationContext, "UnAuthorized - Please login.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    applicationContext,
                     event.errorMessage,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    companion object {

        private var mBus: Bus? = null
        val ROOT_URL = "https://api.flickr.com/services/rest/"
        val API_KEY = "b6a57edcc748369771434a908122cf28"
        val API_SECRET = "ac7cb8e0cfb14eb1"
    }

}
