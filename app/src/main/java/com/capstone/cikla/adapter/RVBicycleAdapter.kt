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
        private val bicycleList: List<Bicycle>
): RecyclerView.Adapter<RVBicycleAdapter.BicycleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BicycleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BicycleViewHolder(layoutInflater.inflate(R.layout.item_bicycle, parent, false))
    }

    override fun onBindViewHolder(holder: BicycleViewHolder, position: Int) {
        val bicycle = bicycleList[position]
        holder.bind(bicycle)
    }

    override fun getItemCount() = bicycleList.size

    class BicycleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(bicycle: Bicycle) {
            Picasso.get().load(bicycle.image).into(itemView.imgBi)
            itemView.tvCode.text = bicycle.code
        }
    }



}