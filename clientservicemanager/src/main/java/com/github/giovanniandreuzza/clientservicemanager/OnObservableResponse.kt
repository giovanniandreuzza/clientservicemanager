package com.github.giovanniandreuzza.clientservicemanager

import okhttp3.ResponseBody

interface OnObservableResponse {
    fun onResponseError(errorCode: Int?, errorBody: ResponseBody?)

    fun onResponseComplete(response: Any?)
}