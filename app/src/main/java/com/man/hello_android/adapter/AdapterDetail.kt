package com.man.hello_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.man.hello_android.R
import kotlinx.android.synthetic.main.item_feature.view.*

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 08, August, 2019
 */
class AdapterDetail (private val list : List<String>, private val context: Context) :
    RecyclerView.Adapter<AdapterDetail.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_feature, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.feature.text = list[position]
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val feature = view.itemFeature!!
    }
}