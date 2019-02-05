package com.umut.trendyolproject.model;

import com.google.gson.annotations.SerializedName;

public class PhotoUrlModel
{
    @SerializedName("type")
    public  String type;

    @SerializedName("_content")
    public  String photoUrl;

    public  String getPhotoUrl()
    {
        return photoUrl;
    }

    public  String getType()
    {
        return type;
    }

    public  void setPhotoUrl(String photoUrl)
    {
        this.photoUrl = photoUrl;
    }

    public  void setType(String type)
    {
        this.type = type;
    }
}
