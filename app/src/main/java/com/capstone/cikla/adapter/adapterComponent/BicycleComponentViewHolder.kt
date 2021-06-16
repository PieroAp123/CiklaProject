package com.capstone.cikla.adapter.adapterComponent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.capstone.cikla.R
import com.capstone.cikla.user.DataBicycle.ComponenteBicycle

class BicycleComponentViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_component, parent, false)){

    private var componentBicycle: TextView = itemView.findViewById(R.id.textNameComponent)
    //private var precioComponent: TextView = itemView.findViewById(R.id.textPrecio)

    fun bind(bicycleComponent: ComponenteBicycle) {
        //precioComponent.text = bicycleComponent.precio.toString()
        //cantidadComponent.text = bicycleComponent.cantidad.toString()
        componentBicycle.text = bicycleComponent.componente.description
    }
}