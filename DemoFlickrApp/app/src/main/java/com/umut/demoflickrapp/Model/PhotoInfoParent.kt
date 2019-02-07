package com.umut.demoflickrapp.Model

import com.google.gson.annotations.SerializedName


class PhotoInfoParent {
    @SerializedName("photo")
    val photo: PhotoInfo? = null

    @SerializedName("stat")
    val stat: String? = null
}
