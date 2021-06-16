package com.capstone.cikla.network

import com.capstone.cikla.user.DataBicycle.Sede
import com.google.gson.annotations.SerializedName

data class SedeResponse (
    @SerializedName("sedes")
    val sede: List<Sede>
)

