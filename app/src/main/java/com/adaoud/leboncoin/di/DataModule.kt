package com.adaoud.leboncoin.di


import com.adaoud.data.network.LeBoncoinApi
import com.adaoud.data.network.NetworkAlbumsRepository
import com.adaoud.leboncoin.utils.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
class DataModule {


    @Provides
    internal fun provideNetworkAlbumsRepository(albumsApi: LeBoncoinApi): NetworkAlbumsRepository {
        return NetworkAlbumsRepository(albumsApi)
    }

}
