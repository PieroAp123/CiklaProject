package com.capstone.cikla.network

import com.capstone.cikla.user.Bicycle
import com.capstone.cikla.user.Bicycles
import com.capstone.cikla.user.User
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @POST("login")
    fun doLogin(@Body params: RequestBody): Call<LoginResponse>

    @POST("usuario")
    fun newUser(@Body params: RequestBody): Call<UserResponse>

    @GET("usuarios")
    fun getUsers(): Call<List<User>>

    @GET("bicicletas")
    fun getBicycle(): Call<Bicycles>

}