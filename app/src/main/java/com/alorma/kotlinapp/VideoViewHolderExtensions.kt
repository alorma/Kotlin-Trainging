package com.alorma.kotlinapp

import kotlinx.android.synthetic.main.view_media_item_video.view.*

fun MediaAdapter.VideoItemHolder.bind(mediaItem: MediaItem,
                                      reproduceCallbackFunction: MediaAdapter.VideoItemHolder.(mediaItem: MediaItem) -> Unit,
                                      callbackFunction: MediaAdapter.VideoItemHolder.(mediaItem: MediaItem) -> Unit) {

    val holder = this
    with(itemView) {
        media_title.text = mediaItem.title
        media_thumb.setImageUrl(mediaItem.url)

        playButton.setOnClickListener { reproduceCallbackFunction.invoke(holder, mediaItem) }
        setOnClickListener { callbackFunction.invoke(holder, mediaItem) }
    }
}
