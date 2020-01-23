package com.adaoud.domain

import kotlinx.coroutines.Deferred
import kotlin.coroutines.CoroutineContext

interface AlbumsRepository {

    fun refreshAlbumList(coroutineContext: CoroutineContext): Deferred<Albums?>
}