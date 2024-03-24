package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter (private val dataList: ArrayList<ImageModel>): RecyclerView.Adapter<MyAdapter.ViewHolderClass>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener:onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolderClass(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.itemImage.setImageResource(currentItem.dataImage)
        holder.itemTextView.setText(currentItem.dataTitle)
    }

    class ViewHolderClass(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        val itemImage:ImageView = itemView.findViewById(R.id.imageView)
        val itemTextView:TextView = itemView.findViewById(R.id.textView)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

}

