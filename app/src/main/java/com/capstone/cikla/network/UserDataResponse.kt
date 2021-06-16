package com.capstone.cikla.network

import com.capstone.cikla.user.User.User
import com.google.gson.annotations.SerializedName

data class UserDataResponse(
    @SerializedName("usuarios")
    val users: List<User>
)
