package com.capstone.cikla.user.DataBicycle

import com.google.gson.annotations.SerializedName

data class ComponenteBicycle (
        @SerializedName("id")
        val id: Int,
        @SerializedName("cantidad")
        val cantidad: Float,
        @SerializedName("componente")
        val componente: Componente,
        @SerializedName("fechaCreacion")
        val dateCreation: String,
        @SerializedName("usuarioCreacion")
        val userCreation: Int,
        @SerializedName("estado")
        val estado: String
)