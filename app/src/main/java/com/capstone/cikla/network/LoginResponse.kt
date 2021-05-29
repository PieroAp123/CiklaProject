package com.capstone.cikla.network

import com.capstone.cikla.user.User
import com.google.gson.annotations.SerializedName

data class LoginResponse (
        @SerializedName("usuarioLogeado")
        val userLogin: List<User>
)