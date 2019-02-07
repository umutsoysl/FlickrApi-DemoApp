package com.umut.demoflickrapp.ui.Activity

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.alexvasilkov.gestures.views.GestureImageView
import com.squareup.otto.Subscribe
import com.squareup.picasso.Picasso
import com.umut.demoflickrapp.network.AppEvent.AppEvents
import com.umut.demoflickrapp.Model.Photo
import com.umut.demoflickrapp.R
import com.umut.demoflickrapp.Util.Utils


class FullScreenImageFragment : Fragment() {
    private var photo: Photo? = null
    private var app: PhotoGalery? = null
    private var viewLayout: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            photo = arguments!!.getParcelable<Photo>(PARAM_PHOTO)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewLayout = inflater.inflate(R.layout.fullscreen_image_layout, container, false)
        val imgDisplay = viewLayout!!.findViewById(R.id.imgDisplay) as GestureImageView
        val btnClose = viewLayout!!.findViewById(R.id.btnClose) as Button
        val path = Utils.getImageUrl(
            photo!!.getFarm(),
            photo!!.getServer(),
            photo!!.getId(),
            photo!!.getSecret(),
            Utils.LARGE_1024
        )
        try {
            Picasso.with(activity!!.applicationContext).load(path).fit().centerInside().error(R.drawable.reload_small)
                .into(imgDisplay)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        btnClose.setOnClickListener {
            activity!!.finish()
        }

        val description = viewLayout!!.findViewById(R.id.description) as TextView
        val title = viewLayout!!.findViewById(R.id.title) as TextView
        title.setText(photo!!.getTitle())
        description.setText(photo!!.getDescription())
        return viewLayout
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        app = activity!!.application as PhotoGalery
        app!!.bus.register(this)
        app!!.bus.post(AppEvents.PhotoInfoRequest(arguments!!.getString(PARAM_PHOTO_ID)))
    }

    @Subscribe
    fun getPhotoInfo(response: AppEvents.PhotoInfoResponse?) {
        if (response != null) {
            val photoInfoResponse = response!!.response
            val photoInfo = photoInfoResponse.body()!!.photo
            val owner = viewLayout!!.findViewById(R.id.owner) as TextView
            val postDate = viewLayout!!.findViewById(R.id.postDate) as TextView
            if (photoInfo != null) {
                Log.d("TAG", "PHOTO DETAILS: " + photoInfo!!.id)
                val user = photoInfo!!.owner
                val dates = photoInfo!!.dateModel
                if (user != null) {
                    owner.setText(user!!.username)
                }
                if (dates != null) {
                    val photoTakeDate = "Take Date: " + Utils.convertDateFormat(photoInfo!!.dateModel!!.takenDate.toString())
                    postDate.text = photoTakeDate
                }
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        app!!.bus.unregister(this)
    }

    companion object {
        private val PARAM_PHOTO_ID = "PHOTO_ID"
        private val PARAM_PHOTO = "PHOTO"

        fun newInstance(photoId: String, photo: Photo): FullScreenImageFragment {
            val fragment = FullScreenImageFragment()
            val args = Bundle()
            args.putString(PARAM_PHOTO_ID, photoId)
            args.putParcelable(PARAM_PHOTO, photo)
            fragment.arguments = args
            return fragment
        }
    }
}
