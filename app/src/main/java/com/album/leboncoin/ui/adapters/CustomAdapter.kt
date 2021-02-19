package com.album.leboncoin.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.album.leboncoin.R
import com.album.leboncoin.data.Item
import com.album.leboncoin.data.AlbumItem
import kotlinx.android.synthetic.main.item_album.view.*

class CustomAdapter(private val albumList: AlbumItem) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(albumList.items[position])
    }

    override fun getItemCount(): Int = albumList.items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(repo: Item) {
            with(repo) {
                itemView.tv_id.text = id.toString()
                itemView.tv_album_id.text = albumId.toString()
                itemView.tv_title.text = title
            }
        }
    }
}