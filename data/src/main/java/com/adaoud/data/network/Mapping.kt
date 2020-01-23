package com.adaoud.data.network

import com.adaoud.domain.Albums


fun AlbumsResponseJson.toModel(): Albums?{

    return Albums(
        lstAlbums = this.lstAlbums?.mapNotNull { it?.toModel() }
    )

}


fun AlbumJson.toModel(): Albums.Album {
    return Albums.Album(
        id = id,
        albumId = albumId,
        title = title,
        imgUrl = url,
        thumbnailUrl = thumbnailUrl
    )
}