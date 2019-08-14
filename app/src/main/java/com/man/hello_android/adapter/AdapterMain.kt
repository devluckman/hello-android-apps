package com.man.hello_android.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.man.hello_android.R
import com.man.hello_android.model.OsAndroid
import com.man.hello_android.utils.DataHelper
import com.man.hello_android.view.detail.DetailActivity
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 07, August, 2019
 */
class AdapterMain (private val list: List<OsAndroid>, private val context: Context)
    : RecyclerView.Adapter<AdapterMain.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val release = context.resources.getString(R.string.release_date)
        val number = context.resources.getString(R.string.number_version)
        holder.nameVersion.text = list[position].name
        holder.releaseDate.text = release + list[position].release_date
        holder.numberVersion.text = number + list[position].version
        DataHelper.loadImage(holder.iconOs, list[position].icon, context)

        holder.cv.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ANDRO, list[position])
            context.startActivity(intent)
        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameVersion = view.nameVersion!!
        val releaseDate = view.releaseDate!!
        val numberVersion = view.numberVersion!!
        val iconOs = view.iconOs!!
        val cv = view.cvMain!!
    }

/*
    private fun loadImage(view : ImageView, img : String?){
        try {
            val inputstream = context.assets.open("images/$img")
            val drawable = Drawable.createFromStream(inputstream, null)
            view.setImageDrawable(drawable)
        }catch (e : Exception){
            Log.e("Adapter", e.message)
        }
    }
*/

    companion object {
        const val ANDRO = "ANDRO"
    }
}