package com.adaoud.data.network

import com.adaoud.domain.Albums
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlin.coroutines.CoroutineContext

class NetworkAlbumsRepository(val albumsApi: LeBoncoinApi) {



    fun getAlbumsAsync(coroutineContext: CoroutineContext): Deferred<Albums?> {
        return CoroutineScope(coroutineContext).async {
            val body = albumsApi.getAllAlbumsAsync(
            ).execute().body()


            body?.toModel()

        }
    }
}