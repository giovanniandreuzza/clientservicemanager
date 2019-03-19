package com.github.giovanniandreuzza.clientservicemanager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseRepository {

    fun <R> performRequest(requestToPerform: Call<R>): LiveData<BaseResponse<R>> {
        val data = MutableLiveData<BaseResponse<R>>()

        requestToPerform.enqueue(object : Callback<R> {
            override fun onResponse(call: Call<R>, response: Response<R>) {
                data.value = BaseResponse(
                    response.body(),
                    response.code(),
                    response.errorBody()
                )
            }

            override fun onFailure(call: Call<R>, t: Throwable) {
                data.value = BaseResponse(null, -1, null)
            }
        })

        return data
    }

}