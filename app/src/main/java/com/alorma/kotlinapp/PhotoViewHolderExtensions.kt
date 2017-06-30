package com.alorma.kotlinapp

import kotlinx.android.synthetic.main.view_media_item_photo.view.*

fun MediaAdapter.PhotoItemHolder.bind(mediaItem: MediaItem,
                                      callbackFunction: MediaAdapter.PhotoItemHolder.(mediaItem: MediaItem) -> Unit) {

    val holder = this
    with(itemView) {
        media_title.text = mediaItem.title
        media_thumb.setImageUrl(mediaItem.url)
        setOnClickListener { callbackFunction.invoke(holder, mediaItem) }
    }
}

