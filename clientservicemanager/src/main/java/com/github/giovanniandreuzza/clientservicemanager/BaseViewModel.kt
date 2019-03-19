package com.github.giovanniandreuzza.clientservicemanager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    fun <T> setViewModelObservable(viewModelObservable: LiveData<T>): LiveData<Any> {
        val a = MediatorLiveData<Any>()
        a.addSource(viewModelObservable) {
            it as BaseResponse<T>

            if(it.code != 200)
                a.value = BaseResponseError(it.code, it.errorBody)
            else
                a.value = it.body
        }
        return a
    }

}