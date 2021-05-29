package com.capstone.cikla.user.DataBicycle

import com.google.gson.annotations.SerializedName

data class Talla (
        @SerializedName("id")
        val id: Int,
        @SerializedName("descripcion")
        val description: String,
        @SerializedName("medidaMinimaCm")
        val medidaMinima: Float,
        @SerializedName("medidaMaximaCm")
        val medidaMaxima: Float,
        @SerializedName("fechaCreacion")
        val dateCreation: String,
        @SerializedName("usuarioCreacion")
        val userCreation: Int,
        @SerializedName("estado")
        val estado: String
)

