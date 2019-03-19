package com.github.giovanniandreuzza.clientservicemanager

import okhttp3.ResponseBody

data class BaseResponse<out T>(
    private val _body: T? = null,
    private val _code: Int? = null,
    private val _errorBody: ResponseBody? = null
) {

    val body: T?
        get() = _body

    val code: Int?
        get() = _code

    val errorBody: ResponseBody?
        get() = _errorBody

}