package com.capstone.cikla.adapter.adapterSede

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.cikla.network.SedeResponse
import com.capstone.cikla.user.DataBicycle.Sede

class SedeAdapter(
    private val sedeItem: List<Sede>,
    private val OnItemClick: (String, String) -> Unit
): RecyclerView.Adapter<SedeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SedeViewHolder {
        return SedeViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: SedeViewHolder, position: Int) {
        val latitudeSede: String = sedeItem[position].latitude
        val longitudeSede: String = sedeItem[position].longitude
        holder.bind(sedeItem[position])
        holder.itemView.setOnClickListener {
            OnItemClick(latitudeSede, longitudeSede)
        }
    }

    override fun getItemCount() = sedeItem.size

}