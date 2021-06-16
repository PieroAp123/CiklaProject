package com.capstone.cikla.adapter.adapterComponent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.cikla.user.DataBicycle.ComponenteBicycle

class BicycleComponentAdapter(
    private val bicycleComponent: List<ComponenteBicycle>
): RecyclerView.Adapter<BicycleComponentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BicycleComponentViewHolder {
        return BicycleComponentViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: BicycleComponentViewHolder, position: Int) {
        //val component: String = bicycleComponent[position].componente.description
        holder.bind(bicycleComponent[position])
    }

    override fun getItemCount() = bicycleComponent.size

}