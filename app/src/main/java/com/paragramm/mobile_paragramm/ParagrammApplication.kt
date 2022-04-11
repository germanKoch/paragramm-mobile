package com.paragramm.mobile_paragramm

import android.app.Application

class ParagrammApplication: Application() {
    val appComponent = DaggerApplicationGraph.create()
}