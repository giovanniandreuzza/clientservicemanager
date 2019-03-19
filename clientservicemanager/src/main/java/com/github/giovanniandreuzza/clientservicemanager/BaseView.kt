package com.github.giovanniandreuzza.clientservicemanager

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import okhttp3.ResponseBody

abstract class BaseView : OnObservableResponse {

    fun observeViewModel(owner: LifecycleOwner, viewModelObservable: LiveData<*>, baseView: BaseView) {
        viewModelObservable.observe(owner,
            Observer {
                when (it) {
                    is BaseResponseError -> onResponseError(it.errorCode, it.errorBody)
                    else -> baseView.onResponseComplete(it)
                }
            })
    }

    override fun onResponseComplete(response: Any?) {}

    override fun onResponseError(errorCode: Int?, errorBody: ResponseBody?) {}

}