package com.umut.demoflickrapp.network.AppEvent


class ApiError {

    var statusCode: Int = 0
    var errorMessage: String? = null
    //    public boolean isRetryRequest() {
    //        return retryRequest;
    //    }
    //
    //    public void setRetryRequest(boolean retryRequest) {
    //        this.retryRequest = retryRequest;
    //    }

    val errorDetails: String? = null
    //private boolean retryRequest;

    constructor(statusCode: Int, errorMessage: String) { //, boolean retryRequest
        this.statusCode = statusCode
        this.errorMessage = errorMessage
        //this.retryRequest = retryRequest;
    }

    constructor() {

    }
}