package com.adaoud.leboncoin.ui.list

import com.adaoud.domain.Albums

data class AlbumViewData(
    val albumTitle: String?,
    val albumCover: String?
)



fun Albums.Album.toViewData()= AlbumViewData(
    albumTitle = title,
    albumCover = thumbnailUrl
)