package com.umut.trendyolproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OwnerModel
{
    @SerializedName("nsid")
    public static int userId;

    @SerializedName("username")
    public static String userName;

    @SerializedName("realname")
    public static String fullName;


    public static String getUserName()
    {
        return userName;
    }

    public static int getUserId()
    {
        return userId;
    }

    public static String getFullName()
    {
        return fullName;
    }

    public static void setFullName(String fullName)
    {
        OwnerModel.fullName = fullName;
    }

    public static void setUserId(int userId)
    {
        OwnerModel.userId = userId;
    }

    public static void setUserName(String userName)
    {
        OwnerModel.userName = userName;
    }

}
