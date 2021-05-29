package com.capstone.cikla.user.DataBicycle

import com.google.gson.annotations.SerializedName

data class ColorBicycle (
        @SerializedName("id")
        val id: Int,
        @SerializedName("descripcion")
        val description: String,
        @SerializedName("fechaCreacion")
        val dateCreation: String,
        @SerializedName("usuarioCreacion")
        val userCreation: Int,
        @SerializedName("estado")
        val estado: String
)

