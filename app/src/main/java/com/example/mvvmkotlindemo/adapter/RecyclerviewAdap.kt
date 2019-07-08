package com.example.mvvmkotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmkotlindemo.R
import com.example.mvvmkotlindemo.model.NicePlace
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerviewAdap(val mNicePlace: List<NicePlace>?, val context : Context) : RecyclerView.Adapter<RecyclerviewAdap.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false))
    }

    override fun getItemCount(): Int {
       return mNicePlace?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.title.text =  mNicePlace?.get(position)?.name

        val defalutOption = RequestOptions.errorOf(R.mipmap.ic_launcher)
        Glide.with(context).setDefaultRequestOptions(defalutOption).load(mNicePlace?.get(position)?.imageurl).into(holder.profile_Image)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile_Image = itemView.profile_image
        val title = itemView.txt_title
    }
}