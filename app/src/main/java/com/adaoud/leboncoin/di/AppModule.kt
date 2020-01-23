package com.adaoud.leboncoin.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import java.util.Locale
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    fun provideLocale(): Locale = Locale.getDefault()


//    @Provides
//    @Singleton
//    fun provideAccountViewModel(userSession: UserSession, storesManager: UserStoresManager, userProfile: UserProfile, itmConnectProvider: ItmConnectProvider, syncAccountInteractor: SyncAccountInteractor): AccountViewModel {
//        return AccountViewModel(userSession, userProfile, storesManager, itmConnectProvider, syncAccountInteractor)
//    }


}
