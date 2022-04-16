package com.paragramm.mobile_paragramm

import android.app.Application
import android.content.Context

class ParagrammApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        sApplication = this
    }

    companion object {
        lateinit var sApplication: Application

        val context: Context
            get() {
                return sApplication.applicationContext
            }
    }
}