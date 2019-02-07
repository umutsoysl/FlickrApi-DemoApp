package com.umut.demoflickrapp.Model

import com.google.gson.annotations.SerializedName


class PhotosParent {
    @SerializedName("photos")
    var photos: Photos? = null
        internal set
    @SerializedName("stat")
    var stat: String? = null
        internal set
}
