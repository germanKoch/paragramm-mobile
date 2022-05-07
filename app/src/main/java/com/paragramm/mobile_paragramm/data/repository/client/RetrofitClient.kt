package com.paragramm.mobile_paragramm.data.repository.client

import com.google.gson.GsonBuilder
import com.paragramm.mobile_paragramm.config.BACKEND_URL
import com.paragramm.mobile_paragramm.config.ZonedDateTypeAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.ZonedDateTime


class RetrofitClient {

    companion object {
        @Volatile
        private var INSTANCE: Retrofit? = null

        private val gson = GsonBuilder()
            .registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTypeAdapter)
            .create()

        fun getClient(): Retrofit {
            if (INSTANCE == null) {
                synchronized(this) {
                    if (INSTANCE == null) {
                        INSTANCE = Retrofit.Builder()
                            .baseUrl(BACKEND_URL)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }

}