package com.adaoud.data.local

import androidx.lifecycle.LiveData
import java.util.concurrent.Executors


class LocalAlbumsRepository(val albumDao: AlbumDao)
{

    private val executor = Executors.newSingleThreadExecutor()

    private fun insertAlbumsInDB(albums: List<AlbumEntity>) {
        executor.execute {
            albumDao.insertAll(albums)
        }
    }


    fun getAllAlbums(page: Int): LiveData<List<AlbumEntity>> {

        return albumDao.getAll()
    }

}