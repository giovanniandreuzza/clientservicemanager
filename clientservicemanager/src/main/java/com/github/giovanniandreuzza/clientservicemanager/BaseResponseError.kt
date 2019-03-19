package com.github.giovanniandreuzza.clientservicemanager

import okhttp3.ResponseBody

data class BaseResponseError(val errorCode: Int?, val errorBody: ResponseBody?)