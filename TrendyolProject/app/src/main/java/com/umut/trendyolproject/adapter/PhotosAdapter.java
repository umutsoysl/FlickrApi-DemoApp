package com.umut.trendyolproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.umut.trendyolproject.R;
import com.umut.trendyolproject.model.PhotosModel;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.MyViewHolder> {

    private List<PhotosModel> photoList;
    private Context context = null;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView username, title;
        CircularImageView photoView;
        ImageView userProfilePhoto;

        @SuppressLint("WrongViewCast")
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            username = (TextView) view.findViewById(R.id.username);
            photoView = (CircularImageView) view.findViewById(R.id.photo);
            userProfilePhoto = (ImageView) view.findViewById(R.id.profilePhoto);
        }
    }


    public PhotosAdapter(Context context , List<PhotosModel> photoList) {
        this.context = context;
        this.photoList = photoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PhotosModel photo = photoList.get(position);
        holder.title.setText(photo.getTitle());
        holder.username.setText(photo.getOwner());

        int width= context.getResources().getDisplayMetrics().widthPixels;
        int height= context.getResources().getDisplayMetrics().heightPixels;

        //https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
        String url = "https://farm"+photo.getFarm()+".staticflickr.com/"+photo.getServer()+"/"+photo.getSecret();
        Picasso.with(context)
                .load(url)
                .resize((width / 2 + width / 4), (height/8 + height/10))
                .centerInside()
                .into(holder.photoView);

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }
}
