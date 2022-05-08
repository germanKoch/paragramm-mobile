package com.paragramm.mobile_paragramm.repository.network.retrofit

import com.google.gson.GsonBuilder
import com.paragramm.mobile_paragramm.config.BACKEND_URL
import com.paragramm.mobile_paragramm.config.ZonedDateTypeAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.time.ZonedDateTime

object NetworkService {

    private val loggingInterceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    val client: OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    inline fun <reified T> client(): T {
        val gson = GsonBuilder()
            .registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTypeAdapter)
            .create()

        return Retrofit.Builder()
            .baseUrl(BACKEND_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
            .create(T::class.java)
    }
}