package com.adaoud.leboncoin.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adaoud.leboncoin.R
import com.adaoud.leboncoin.utils.setImageUrl
import kotlinx.android.synthetic.main.item_album.view.*


class AlbumAdapter(val context: Context, val items: List<AlbumViewData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_album,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = items.get(position)
        if (holder is ViewHolder) {
            item.apply {
                holder.albumTitle.text = albumTitle
                holder.albumCover.setImageUrl(item.albumCover)
            }
        }



    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val albumTitle = view.item_album_title_album
        val albumCover = view.item_album_img_album

    }


}