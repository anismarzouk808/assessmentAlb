package com.adaoud.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AlbumDao {

    @Query("SELECT * FROM albums")
    fun getAll(): LiveData<List<AlbumEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(albums : List<AlbumEntity>)

}