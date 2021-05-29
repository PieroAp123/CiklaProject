package com.capstone.cikla.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.capstone.cikla.R
import com.capstone.cikla.user.Bicycle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_bicycle.view.*

class BicycleViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_bicycle, parent, false)) {

    private var codeBicycle: TextView = itemView.findViewById(R.id.tvCode)
    var descriptionBicycle: TextView = itemView.findViewById(R.id.tvDescripcion)
    var imageBicycle: ImageView = itemView.findViewById(R.id.imgBi)

    fun bind(bicycle: Bicycle) {
        val bytes = Base64.decode(bicycle.image, Base64.DEFAULT)
        val bitmap: Bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)

        imageBicycle.setImageBitmap(bitmap)
        //Picasso.get().load(bytes.toString()).into(imageBicycle)
        codeBicycle.text = bicycle.code
        descriptionBicycle.text = bicycle.catergoria.description

    }

}