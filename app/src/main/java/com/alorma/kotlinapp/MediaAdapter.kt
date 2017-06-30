package com.alorma.kotlinapp;

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class MediaAdapter : RecyclerView.Adapter<MediaAdapter.ItemHolder>() {

    private val VIEW_TYPE_PHOTO: Int = 1
    private val VIEW_TYPE_VIDEO: Int = 2

    val list: MutableList<MediaItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return when (viewType) {
            VIEW_TYPE_VIDEO -> {
                val view = parent.inflate(R.layout.view_media_item_video)
                VideoItemHolder(view)
            }
            else -> {
                val view = parent.inflate(R.layout.view_media_item_photo)
                PhotoItemHolder(view)
            }
        }
    }

    override fun onBindViewHolder(itemHolder: ItemHolder, position: Int) {
        when (itemHolder) {
            is PhotoItemHolder -> itemHolder.bind(list[position]) {
                toast("Big photo: ${it.title}")
            }
            is VideoItemHolder -> itemHolder.bind(list[position], {
                toast("Playing: ${it.title}")
            })
                {
                    toast("Big video: ${it.title}")
                }
            else -> {
            }

        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int = when (list[position].type) {
        MediaItem.Type.PHOTO -> VIEW_TYPE_PHOTO
        MediaItem.Type.VIDEO -> VIEW_TYPE_VIDEO
    }

    open class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    class PhotoItemHolder(itemView: View) : ItemHolder(itemView)
    class VideoItemHolder(itemView: View) : ItemHolder(itemView)

    fun addAll(media: Collection<MediaItem>) {
        list.addAll(media)
        notifyDataSetChanged()
    }
}