package com.umut.trendyolproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TitleModel
{
    @SerializedName("perpage")
    public  int perpage;

    @SerializedName("total")
    public  int total;

    @SerializedName("page")
    public  int page;

    @SerializedName("photo")
    @Expose
    public  ArrayList<ContentModel> photo;

    public  int getPage()
    {
        return page;
    }

    public  int getPerpage()
    {
        return perpage;
    }

    public  ArrayList<ContentModel> getPhoto()
    {
        return photo;
    }

    public  int getTotal()
    {
        return total;
    }

    public  void setPage(int page)
    {
       page = page;
    }

    public  void setPerpage(int perpage)
    {
        this.perpage = perpage;
    }

    public  void setPhoto(ArrayList<ContentModel> photo)
    {
        this.photo = photo;
    }

    public  void setTotal(int total)
    {
        this.total = total;
    }
}
