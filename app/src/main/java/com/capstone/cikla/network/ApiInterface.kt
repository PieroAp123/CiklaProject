package com.capstone.cikla.network

import com.capstone.cikla.user.User
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("usuarios")
    fun getUsers(): Call<List<User>>

    @POST("usuario")
    fun newUser(): Call<User>

}