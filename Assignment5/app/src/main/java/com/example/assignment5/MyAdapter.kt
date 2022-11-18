package com.example.assignment5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_list.view.*

class MyAdapter (var productList: ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list, parent,false)

        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.txtProductName.text = productList[position].title
        holder.itemView.txtProductDescription.text = productList[position].description
    }

    override fun getItemCount(): Int {
        return  productList.size
    }

    inner class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)
}