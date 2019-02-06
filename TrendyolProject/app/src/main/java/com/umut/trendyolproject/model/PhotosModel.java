package com.umut.trendyolproject.model;

import com.google.gson.annotations.SerializedName;

public class PhotosModel
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

    @SerializedName("ispublic")
    public  String ispublic;

    @SerializedName("isfriend")
    public  String isfriend;

    @SerializedName("isfamily")
    public  String isfamily;

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

    public String getIspublic()
    {
        return ispublic;
    }

    public String getIsfamily()
    {
        return isfamily;
    }

    public String getIsfriend()
    {
        return isfriend;
    }

    public void setIsfamily(String isfamily)
    {
        this.isfamily = isfamily;
    }

    public void setIsfriend(String isfriend)
    {
        this.isfriend = isfriend;
    }

    public void setIspublic(String ispublic)
    {
        this.ispublic = ispublic;
    }
}
