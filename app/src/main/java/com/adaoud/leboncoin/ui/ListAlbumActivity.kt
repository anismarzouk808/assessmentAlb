package com.adaoud.leboncoin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adaoud.leboncoin.R

class ListAlbumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newFragment = ListAlbumsFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.framgment_container, newFragment).commit()
    }

}
