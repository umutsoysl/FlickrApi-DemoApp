package com.umut.demoflickrapp.ui.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.umut.demoflickrapp.ui.Activity.ShowPhotoActivity
import com.umut.demoflickrapp.Model.Photo
import com.umut.demoflickrapp.Model.Photos
import com.umut.demoflickrapp.R
import com.umut.demoflickrapp.Util.Utils
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList


class SearchListAdapter(
    private val context: Context,
    private val recyclerView: RecyclerView,
    private val photos: Photos?,
    private val loadMoreCallback: LastItemVisible?
) :
    RecyclerView.Adapter<SearchListAdapter.DataObjectHolder>() {

    private var data: ArrayList<Photo>? = null
    private val TAG = "SearchListAdapter"

    class DataObjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val title: TextView
        internal val ownerTxt: TextView
        internal val image: ImageView
        internal val profilePhoto : CircleImageView

        init {
            title = itemView.findViewById(R.id.title) as TextView
            ownerTxt = itemView.findViewById(R.id.ownerTxt) as TextView
            image = itemView.findViewById(R.id.image) as ImageView
            profilePhoto = itemView.findViewById(R.id.userProfileIcon) as CircleImageView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataObjectHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_row_item, parent, false)
        view.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(view.context, ShowPhotoActivity::class.java)
            intent.putExtra("PHOTOS", photos)
            intent.putExtra("POSITION", recyclerView.getChildLayoutPosition(view))
            view.context.startActivity(intent)
        })
        return DataObjectHolder(view)
    }

    init {
        data = photos!!.getPhotoArrayList()
    }

    fun add(data: Photo) {
        if (this.photos == null) {
            this.data = ArrayList<Photo>()
        }
        this.data!!.add(data)
        val position = this.data!!.size - 1
        notifyItemInserted(position)
    }

    fun addData(data: ArrayList<Photo>) {
        if (this.data == null) {
            this.data = data
        } else {
            this.data!!.addAll(data)
        }
        notifyDataSetChanged()
    }

    fun remove(item: Photo) {
        val position = data!!.indexOf(item)
        data!!.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int {
        return if (data == null) {
            0
        } else data!!.size
    }

    fun getItem(position: Int): Photo {
        return data!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun onBindViewHolder(holder: DataObjectHolder, position: Int) {
        val item = getItem(position)
        holder.title.setText(item.getTitle())
        val path =
            Utils.getImageUrl(item.getFarm(), item.getServer(), item.getId(), item.getSecret(), Utils.SMALL_240)
        //https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
        Picasso.with(context).load(path).fit().centerCrop().into(holder.image)

        if (position == itemCount - 2) {
            loadMoreCallback?.loadMoreData(position)
        }
    }

    interface LastItemVisible {
        fun loadMoreData(lastVisibleItemIndex: Int)
    }
}
