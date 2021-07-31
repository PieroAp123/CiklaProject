package com.capstone.cikla.fragments.rentalFragment


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.capstone.cikla.R
import com.capstone.cikla.user.BicycleData

class RentalViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup
): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_rental, parent, false)) {


    private var codigoBicicleta: TextView = itemView.findViewById(R.id.tvRentalCode)
    private var descripcionBicicleta: TextView = itemView.findViewById(R.id.tvRentalDescripcion)
    private var sedeBicicleta: TextView = itemView.findViewById(R.id.tvRentalSede)
    private var tallaBicicleta: TextView = itemView.findViewById(R.id.tvRentalTalla)
    private var imagenBicicleta: ImageView = itemView.findViewById(R.id.imagenRentalBicicleta)

    fun bind(bicycleData: BicycleData) {
        val bytes = Base64.decode(bicycleData.image, Base64.DEFAULT)
        val bitmap: Bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)

        imagenBicicleta.setImageBitmap(bitmap)
        codigoBicicleta.text = bicycleData.code
        descripcionBicicleta.text = bicycleData.description
        sedeBicicleta.text = bicycleData.sede
        tallaBicicleta.text = bicycleData.talla

    }
}