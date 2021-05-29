package com.capstone.cikla.user

import com.google.gson.annotations.SerializedName

data class Bicycles (
        @SerializedName("bicicletas")
        val bicicletas: List<Bicycle>
)