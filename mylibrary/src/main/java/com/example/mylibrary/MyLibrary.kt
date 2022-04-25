package com.example.mylibrary

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

lateinit var flow: Flow<Int>

class MyLibrary {
    fun getSquare(number: Int) = number * number
    fun loadImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).into(imageView)
    }
    fun setUpFlow() {
        flow = flow {
            Log.d("TAG", "Start flow")
            (0..10).forEach {
                // Emit items with 500 milliseconds delay
                delay(500)
                Log.d("TAG", "Emitting $it")
                emit(it)

            }
        }.flowOn(Dispatchers.Default).flowOn(Dispatchers.Default)
    }

    fun setupClick(text: TextView){
        CoroutineScope(Dispatchers.Main).launch {
            flow.collect {
                Log.d("TAG", it.toString())
                text.text = it.toString()
            }
        }
    }

}