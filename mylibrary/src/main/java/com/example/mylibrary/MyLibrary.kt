package com.example.mylibrary

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class MyLibrary {
    fun getSquare(number: Int) = number * number
    fun loadImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).into(imageView)
    }
}