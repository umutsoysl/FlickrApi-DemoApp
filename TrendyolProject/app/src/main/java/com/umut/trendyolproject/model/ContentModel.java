package com.umut.trendyolproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContentModel
{
    @SerializedName("id")
    public  int id;

    @SerializedName("owner")
    public  String owner;

    @SerializedName("server")
    public  String server;

    @SerializedName("secret")
    public  String secret;

    @SerializedName("farm")
    public  String farm;

    @SerializedName("title")
    public  String title;

    @SerializedName("photo")
    @Expose
    public List<PhotoUrlModel> url;

    public  int getId()
    {
        return id;
    }

    public  String getFarm()
    {
        return farm;
    }

    public  String getOwner()
    {
        return owner;
    }

    public  String getSecret()
    {
        return secret;
    }

    public  String getServer()
    {
        return server;
    }

    public  String getTitle()
    {
        return title;
    }

    public List<PhotoUrlModel> getUrl()
    {
        return url;
    }

    public void setUrl(List<PhotoUrlModel> url)
    {
        this.url = url;
    }

    public  void setFarm(String farm)
    {
        this.farm = farm;
    }

    public  void setId(int id)
    {
        this.id = id;
    }

    public  void setOwner(String owner)
    {
        this.owner = owner;
    }

    public  void setSecret(String secret)
    {
        this.secret = secret;
    }

    public void setServer(String server)
    {
        this.server = server;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
