package com.adaoud.leboncoin

import android.app.Application
import com.adaoud.leboncoin.di.*


class MyApplication : Application()  {

    val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .dataModule(DataModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }
}