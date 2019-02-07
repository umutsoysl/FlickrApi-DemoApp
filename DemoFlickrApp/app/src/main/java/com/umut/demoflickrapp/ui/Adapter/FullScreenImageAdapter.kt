package com.umut.demoflickrapp.ui.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.umut.demoflickrapp.ui.Activity.FullScreenImageFragment
import com.umut.demoflickrapp.Model.Photo
import java.util.ArrayList


class FullScreenImageAdapter(fm: FragmentManager, private val photoArrayList: ArrayList<Photo>?) :
    FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return photoArrayList?.size ?: 0
    }

    override fun getItem(position: Int): Fragment {
        val photo = photoArrayList!![position]
        //Log.d("TAG", "PHOTO ID: " + photo.getId());
        return FullScreenImageFragment.newInstance(photo.getId(), photo)
    }
}
