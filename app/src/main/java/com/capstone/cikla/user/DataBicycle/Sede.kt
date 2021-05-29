package com.capstone.cikla.user.DataBicycle

import com.google.gson.annotations.SerializedName

data class Sede (

        @SerializedName("id")
        val id: Int,
        @SerializedName("descripcion")
        val description: String,
        @SerializedName("direccion")
        val direccion: String,
        @SerializedName("imagen")
        val imageSede: String,
        @SerializedName("latitude")
        val latitude: String,
        @SerializedName("longitude")
        val longitude: String,
        @SerializedName("fechaCreacion")
        val dateCreation: String,
        @SerializedName("usuarioCreacion")
        val userCreation: Int,
        @SerializedName("estado")
        val estado: String
)

