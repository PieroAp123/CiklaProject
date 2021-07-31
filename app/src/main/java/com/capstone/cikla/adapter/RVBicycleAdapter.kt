package com.capstone.cikla.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.cikla.user.Bicycle
import com.capstone.cikla.user.DataBicycle.ComponenteBicycle
import kotlinx.android.synthetic.main.item_bicycle.view.*

class RVBicycleAdapter(
        private val bicycleList: List<Bicycle>,
        private val OnItemClick: (String, String, String, String, String, List<ComponenteBicycle>, String) -> Unit,
): RecyclerView.Adapter<BicycleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BicycleViewHolder {
        return BicycleViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: BicycleViewHolder, position: Int) {
        val nameCategory: String = bicycleList[position].catergoria.description
        val imageBicycle: String = bicycleList[position].image
        val sedeBicycle: String = bicycleList[position].sede.direccion
        val colorBicycle: String = bicycleList[position].color.description
        val codeBicycle: String = bicycleList[position].description
        val codeComponent: String = bicycleList[position].code
        val bicycleComponent: List<ComponenteBicycle> = bicycleList[position].componenteBicycle
        holder.bind(bicycleList[position])
        holder.itemView.setOnClickListener{
            OnItemClick(codeBicycle, nameCategory, imageBicycle, sedeBicycle, colorBicycle, bicycleComponent, codeComponent)
        }

    }

    override fun getItemCount() = bicycleList.size

    /*interface  ItemClickListener {
        fun onClickItem(position: Int)
    }*/

}