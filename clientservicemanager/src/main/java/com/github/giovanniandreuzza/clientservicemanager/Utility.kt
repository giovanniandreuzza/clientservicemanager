package com.github.giovanniandreuzza.clientservicemanager

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T> LiveData<T>.observerViewModel(owner: LifecycleOwner, observer: BaseView) {
    observer.observeViewModel(owner, this, observer)
}