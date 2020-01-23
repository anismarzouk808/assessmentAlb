package com.adaoud.domain



data class Albums(val lstAlbums: List<Album>){


    data class Album(val albumId: Int?
                    , val id: Int?
                    , val title: String?
                    , val imgUrl: String?
                    , val thumbnailUrl: String?)

}
