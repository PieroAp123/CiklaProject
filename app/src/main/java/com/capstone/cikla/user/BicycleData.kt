package com.capstone.cikla.user

import com.capstone.cikla.user.DataBicycle.*
import com.google.gson.annotations.SerializedName

data class BicycleData(
    val code: String,
    val description: String,
    val image: String,
    val sede: String,
    val talla: String
)
