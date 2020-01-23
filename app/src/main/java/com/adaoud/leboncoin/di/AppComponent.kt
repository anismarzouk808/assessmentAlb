package com.adaoud.leboncoin.di

import android.app.Application
import com.adaoud.leboncoin.MyApplication
import com.adaoud.leboncoin.ui.ListAlbumActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, NetworkModule::class, AppModule::class])
interface AppComponent {


     fun inject(app: MyApplication)
    fun inject(activity: ListAlbumActivity)
}