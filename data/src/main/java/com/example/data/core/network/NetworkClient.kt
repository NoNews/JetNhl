package com.example.data.core.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class NetworkClient(okHttp: OkHttpClient) {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://statsapi.web.nhl.com/api/v1/")
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <S> createService(serviceClass: Class<S>): S = retrofit.create(serviceClass)
}