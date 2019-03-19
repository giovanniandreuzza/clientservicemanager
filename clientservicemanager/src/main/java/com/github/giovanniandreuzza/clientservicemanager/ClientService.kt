package com.github.giovanniandreuzza.clientservicemanager

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ClientService private constructor(context: Context, BASE_URL: String) {
    private var retrofit: Retrofit

    companion object {
        private const val CACHE_SIZE: Long = 10 * 1024 * 1024 // 10 MB
        private const val TIMEOUT: Long = 10000

        private var clientService: ClientService? = null

        fun getInstance(context: Context, BASE_URL: String): ClientService {
            return clientService
                ?: ClientService(context, BASE_URL)
        }
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createOkHttpClient(context))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(rx.schedulers.Schedulers.io()))
            .build()
    }

    private fun createOkHttpClient(context: Context): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .cache(Cache(context.cacheDir,
                CACHE_SIZE
            ))
            .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    fun <T> prepareRequest(request: Class<T>): T {
        return retrofit.create(request)
    }
}