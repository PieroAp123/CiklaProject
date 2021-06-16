package com.capstone.cikla.network

import com.capstone.cikla.user.PlanTarifario.Tarifario
import com.google.gson.annotations.SerializedName

data class PlanTarifarioResponse(
    @SerializedName("planesTarifarios")
    val planesTarifarios: List<Tarifario>
)
