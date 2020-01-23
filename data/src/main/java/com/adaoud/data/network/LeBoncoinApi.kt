package com.adaoud.data.network

import retrofit2.Call
import retrofit2.http.GET

interface LeBoncoinApi {

    @GET("img/shared/technical-test.json")
    fun getAllAlbumsAsync(): Call<AlbumsResponseJson>

}