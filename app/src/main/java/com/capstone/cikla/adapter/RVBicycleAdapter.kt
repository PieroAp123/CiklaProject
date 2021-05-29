package com.capstone.cikla.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.cikla.R
import com.capstone.cikla.user.Bicycle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_bicycle.view.*

class RVBicycleAdapter(
        private val bicycleList: List<Bicycle>,
        private val itemClickListener: ItemClickListener,
): RecyclerView.Adapter<BicycleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BicycleViewHolder {
        return BicycleViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: BicycleViewHolder, position: Int) {
        holder.bind(bicycleList[position])
        holder.itemView.setOnClickListener{
            itemClickListener.onClickItem(position)
        }
    }

    override fun getItemCount() = bicycleList.size

    interface  ItemClickListener {
        fun onClickItem(position: Int)
    }

}