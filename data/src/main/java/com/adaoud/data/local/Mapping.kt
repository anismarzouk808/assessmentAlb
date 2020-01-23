package com.adaoud.data.local

import com.adaoud.domain.Albums



fun AlbumEntity.toModel(): Albums.Album {
    return Albums.Album(
        id = id,
        albumId = albumId,
        title = title,
        imgUrl = url,
        thumbnailUrl = thumbnailUrl
    )
}