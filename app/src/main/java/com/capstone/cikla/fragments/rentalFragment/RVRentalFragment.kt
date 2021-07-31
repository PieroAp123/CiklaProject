package com.capstone.cikla.fragments.rentalFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.cikla.network.PlanTarifarioResponse
import com.capstone.cikla.user.BicycleData
import com.capstone.cikla.user.DataBicycle.ComponenteBicycle
import com.capstone.cikla.user.PlanTarifario.Tarifario

class RVRentalFragment(
    private val rentalBicycle: List<BicycleData>,
    private val OnItemClick: (String) -> Unit
): RecyclerView.Adapter<RentalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentalViewHolder {
        return RentalViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: RentalViewHolder, position: Int) {
        val descripcionBicicleta = rentalBicycle[position].code
        holder.bind(rentalBicycle[position])
        holder.itemView.setOnClickListener{
            OnItemClick(descripcionBicicleta)
        }
    }

    override fun getItemCount(): Int = rentalBicycle.size

}