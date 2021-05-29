package com.capstone.cikla.network

import com.google.gson.annotations.SerializedName

open class ErrorResponse (

        @SerializedName("fecha")
        val fecha: String,

        @SerializedName("message")
        val error: String,

        @SerializedName("detalle")
        val detalle: String,


)