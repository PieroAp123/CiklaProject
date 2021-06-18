package com.capstone.cikla.network

import com.capstone.cikla.user.User.User
import com.google.gson.annotations.SerializedName

data class LoginResponse (
        @SerializedName("usuarioLogeado")
        val userLogin: User
)