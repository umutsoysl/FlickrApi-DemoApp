package com.umut.demoflickrapp.Model;


import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.umut.demoflickrapp.R;

import java.util.ArrayList;

public class Photos implements Parcelable {

    @SerializedName("page")
    private String page;
    @SerializedName("pages")
    private String pages;
    @SerializedName("perpage")
    private String perPage;
    @SerializedName("total")
    private String total;
    @SerializedName("photo")
    private ArrayList<Photo> photoArrayList;

    public String getPage() {
        return page;
    }

    public String getPages() {
        return pages;
    }

    public String getPerPage() {
        return perPage;
    }

    public String getTotal() {
        return total;
    }

    public ArrayList<Photo> getPhotoArrayList() {
        return photoArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.page);
        dest.writeString(this.pages);
        dest.writeString(this.perPage);
        dest.writeString(this.total);
        dest.writeTypedList(this.photoArrayList);
    }

    public Photos() {
    }

    protected Photos(Parcel in) {
        this.page = in.readString();
        this.pages = in.readString();
        this.perPage = in.readString();
        this.total = in.readString();
        this.photoArrayList = in.createTypedArrayList(Photo.CREATOR);
    }

    public static final Parcelable.Creator<Photos> CREATOR = new Parcelable.Creator<Photos>() {
        @Override
        public Photos createFromParcel(Parcel source) {
            return new Photos(source);
        }

        @Override
        public Photos[] newArray(int size) {
            return new Photos[size];
        }
    };
}
