package com.capstone.cikla.user.PlanTarifario

import com.google.gson.annotations.SerializedName

data class Tarifario(
    @SerializedName("id")
    val id: Int,
    @SerializedName("descripcion")
    val descriptionTarifario: String,
    @SerializedName("cantidadHoras")
    val hours: Float,
    @SerializedName("precio")
    val pecio: Float,
    @SerializedName("fechaCreacion")
    val dateCreation: String,
    @SerializedName("usuarioCreacion")
    val userCreation: String,
    @SerializedName("estado")
    val estado: String
)
