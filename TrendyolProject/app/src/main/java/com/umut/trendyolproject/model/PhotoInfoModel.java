package com.umut.trendyolproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoInfoModel
{
    @SerializedName("id")
    public static int id;

    @SerializedName("urls")
    @Expose
    public static PhotoUrlModel photoUrl;

    @SerializedName("owner")
    @Expose
    public static OwnerModel owner;

    public static OwnerModel getOwner()
    {
        return owner;
    }

    public static int getId()
    {
        return id;
    }

    public static PhotoUrlModel getPhotoUrl()
    {
        return photoUrl;
    }

    public static void setPhotoUrl(PhotoUrlModel photoUrl)
    {
        PhotoInfoModel.photoUrl = photoUrl;
    }

    public static void setOwner(OwnerModel owner)
    {
        PhotoInfoModel.owner = owner;
    }

    public static void setId(int id)
    {
        PhotoInfoModel.id = id;
    }
}
