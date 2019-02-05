package com.umut.trendyolproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.umut.trendyolproject.R;
import com.umut.trendyolproject.model.ContentModel;
import com.umut.trendyolproject.model.TitleModel;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.MyViewHolder> {

    private List<ContentModel> photoList;
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


    public PhotosAdapter(Context context , List<ContentModel> photoList) {
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
        ContentModel photo = photoList.get(position);
        holder.title.setText(photo.title);
        holder.username.setText(photo.owner);

        Picasso.with(context).load(photo.getUrl().get(0).photoUrl)
                .into(holder.photoView);

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }
}
