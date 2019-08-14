package com.man.hello_android.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import java.io.IOException
import java.nio.charset.Charset


/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 07, August, 2019
 */
object DataHelper {
    fun getJson(context: Context) : String?{
        var json: String? = null
        try {
            val inputStream = context.assets.open("androidos.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return json
    }

    fun loadImage(view : ImageView, img : String?, context: Context){
        try {
            val inputstream = context.assets.open("images/$img")
            val drawable = Drawable.createFromStream(inputstream, null)
            view.setImageDrawable(drawable)
        }catch (e : Exception){
            Log.e("Adapter", e.message)
        }
    }
}