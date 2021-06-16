package com.capstone.cikla.adapter.adapterSede

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.capstone.cikla.R
import com.capstone.cikla.user.DataBicycle.Sede

class SedeViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_sedes, parent, false)){

    private var descriptionSede: TextView = itemView.findViewById(R.id.textSedeDescripcion)
    private var directionSede: TextView = itemView.findViewById(R.id.textSedeDireccion)

    fun bind(sede: Sede) {
        descriptionSede.text = sede.description
        directionSede.text = sede.direccion
    }

}