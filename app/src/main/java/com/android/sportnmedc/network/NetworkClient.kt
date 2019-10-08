package com.android.sportnmedc.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

/**
 * Retrofit2 NetworkClient
 */
class NetworkClient private constructor() {
    companion object {
        @Volatile
        private var instance: NetworkClient? = null

        @JvmStatic
        fun getInstance(): NetworkClient =
            instance ?: synchronized(this) {
                instance ?: NetworkClient().also {
                    instance = it
                }
            }
    }

    private val client = OkHttpClient.Builder().addInterceptor(object : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            val request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()
            return chain.proceed(request)
        }
    })

    private fun getClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.212:3000") // LOCAL TEST Address
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // retrofit 용 rxjava2 adapter
            .client(client.build())
            .build()
    }

    val api: NetworkApi = getClient().create(NetworkApi::class.java)
}