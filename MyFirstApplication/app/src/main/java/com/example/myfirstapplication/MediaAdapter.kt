package com.example.myfirstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

open class MediaAdapter(private val items: List<MediaItem>) :
        RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    //Inflaremos la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_media_item, parent, false)
        return ViewHolder(view)
    }

    //Asignaremos los valores correspondientes a la lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = items[position]
        return holder.bind(item)
    }

    //Devolver el numero de itmes que tiene nuestro MediaAdapter
    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.mediaTitle)
        private val thumb: ImageView = itemView.findViewById(R.id.mediaThumb)

        fun bind(mediaItem: MediaItem){
            title.text = mediaItem.title
            Glide.with(thumb).load(mediaItem.url).into(thumb)
        }
    }
}
