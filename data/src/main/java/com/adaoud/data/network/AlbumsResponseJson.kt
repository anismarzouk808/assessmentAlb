package com.adaoud.data.network

import com.google.gson.annotations.SerializedName


data class AlbumsResponseJson(val lstAlbums: List<AlbumJson>)

data class AlbumJson(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("albumId") val albumId: Int? = null,
    @SerializedName("thumbnailUrl") val thumbnailUrl: String,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String)


