package com.oscarpino.common

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Factory {

    fun retrofitFactory(baseUrl: String): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun<T> apiServiceFactory(baseUrl: String,apiClass: Class<T>): T{
        return retrofitFactory(baseUrl).create<T>(apiClass)
    }
}