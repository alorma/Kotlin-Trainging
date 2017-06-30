package com.alorma.kotlinapp

import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

fun RecyclerView.ViewHolder.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(itemView.context, msg, duration).show()
}

fun ViewGroup.inflate(@LayoutRes id: Int, attach: Boolean = false): View
        = LayoutInflater.from(context).inflate(id, this, attach)

fun ImageView.setImageUrl(url: String,
                          picasso: Picasso = Picasso.with(context),
                          @DrawableRes errorRes: Int = R.mipmap.ic_launcher) {
    picasso.load(url).error(errorRes).into(this)
}
