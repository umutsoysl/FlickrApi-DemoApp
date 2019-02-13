package com.umut.demoflickrapp.network.AppEvent

import com.umut.demoflickrapp.Model.PhotoInfoParent
import com.umut.demoflickrapp.Model.PhotosParent
import retrofit2.Response


class AppEvents {

    class SearchImageRequest(val query: String, val page: Int, val perPage: Int)

    class SearchImageResponse(val response: Response<PhotosParent>)

    class RecentImagesRequest(val page: Int, val perPage: Int)

    class RecentImagesResponse(val response: Response<PhotosParent>)

    class PhotoInfoRequest(val photoId: String)

    class PhotoInfoResponse(val response: Response<PhotoInfoParent>)

}
