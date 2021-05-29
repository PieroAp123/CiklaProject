package com.capstone.cikla.user

import com.capstone.cikla.user.DataBicycle.*
import com.google.gson.annotations.SerializedName

data class Bicycle (
        @SerializedName("id")
        val id: Int,
        @SerializedName("codigo")
        val code: String,
        @SerializedName("descripcion")
        val description: String,
        @SerializedName("observacion")
        val observer: String,
        @SerializedName("imagen")
        val image: String,
        @SerializedName("sede")
        val sede: Sede,
        @SerializedName("maestroEstado")
        val maestroEstado: MaestroEstado,
        @SerializedName("categoria")
        val catergoria: Categoria,
        @SerializedName("talla")
        val talla: Talla,
        @SerializedName("color")
        val color: ColorBicycle,
        @SerializedName("bicicletaComponente")
        val componenteBicycle: List<ComponenteBicycle>,
        @SerializedName("fechaCreacion")
        val dateCreation: String,
        @SerializedName("usuarioCreacion")
        val userCreation: Int,
        @SerializedName("estado")
        val estado: String
)



