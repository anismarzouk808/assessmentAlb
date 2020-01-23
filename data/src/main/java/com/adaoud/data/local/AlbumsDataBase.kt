package com.adaoud.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AlbumEntity::class], version = 1, exportSchema = false)
abstract class AlbumsDataBase : RoomDatabase() {

    abstract fun albumDao(): AlbumDao

}