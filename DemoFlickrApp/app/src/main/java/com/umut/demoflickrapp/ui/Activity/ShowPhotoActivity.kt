package com.umut.demoflickrapp.ui.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.Window
import android.view.WindowManager
import com.umut.demoflickrapp.ui.Adapter.FullScreenImageAdapter
import com.umut.demoflickrapp.Model.Photos
import com.umut.demoflickrapp.R

class ShowPhotoActivity : AppCompatActivity() {

      val PARAMETER_PHOTOS = "PHOTOS"
      val PARAMETER_INDEX = "POSITION"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_show_photo)

        val intent = intent
        val viewPager = findViewById(R.id.pager) as ViewPager
        val photos = intent.getParcelableExtra<Photos>(PARAMETER_PHOTOS)
        val position = intent.getIntExtra(PARAMETER_INDEX, 0)
        val adapter =
            FullScreenImageAdapter(this@ShowPhotoActivity.getSupportFragmentManager(), photos.photoArrayList)
        viewPager.adapter = adapter
        viewPager.currentItem = position
        viewPager.offscreenPageLimit = 1
    }


}
