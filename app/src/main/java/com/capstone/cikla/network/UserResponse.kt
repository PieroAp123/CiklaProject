package com.capstone.cikla.network

import com.capstone.cikla.user.User.User
import com.google.gson.annotations.SerializedName


data class UserResponse(
    @SerializedName("usuario") 
        val users: List<User>,

    @SerializedName("mensaje")
        val message: String
)