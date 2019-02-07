package com.umut.demoflickrapp.Util

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.net.ConnectivityManager
import android.util.Log
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format.DateTimeFormat
import java.lang.Long


object Utils {

    val SMALL_SQUARE = 's'
    val SMALL_SQUARE_150 = 'q'
    val SMALL_240 = 'm'
    val SMALL_320 = 'n'
    val MEDIUM_640 = 'z'
    val LARGE_1024 = 'b'
    val dtf = DateTimeFormat.forPattern("dd MMMM yyyy HH:mm")
    val dtfApi = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")

    fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) {
            return false
        }
        val cm = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    fun getDateTimeFrom(milliseconds: String): String {
        try {
            val date = DateTime(Long.valueOf(milliseconds), DateTimeZone.UTC)
            Log.d("Utils", "Converted Time: " + dtf.print(date))
            return dtf.print(date)
        } catch (e: Exception) {
            e.printStackTrace()
            return milliseconds
        }

    }

    fun convertDateFormat(date: String): String {
        return dtf.print(dtfApi.parseDateTime(date))
    }

    fun getScreenSize(activity: Activity): IntArray {
        val size = Point()
        activity.windowManager.defaultDisplay.getSize(size)
        val width = size.x
        val height = size.y
        return intArrayOf(width, height)
    }

    fun getImageUrl(farmId: String, serverId: String, id: String, secret: String, size: Char): String {
        return String.format("https://farm%s.staticflickr.com/%s/%s_%s_%c.jpg", farmId, serverId, id, secret, size)
    }
}
