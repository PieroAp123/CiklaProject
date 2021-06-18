package com.capstone.cikla.screens.login

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.cikla.network.*
import com.capstone.cikla.user.User.User
import com.capstone.cikla.utils.isValidEmail
import com.capstone.cikla.utils.isValidPassword
import com.google.firebase.auth.FirebaseAuth
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class LoginViewModel: ViewModel() {

    lateinit var auth: FirebaseAuth

    val userLoadError = MutableLiveData<Boolean>() //notificar una accion o error
    val userServiceResponse = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    private val userListString = MutableLiveData<UserDataResponse>()
    private val api = ApiService().getRetrofit()
    val userLiveData = MutableLiveData<LoginResponse>()

    fun login(email:String, password: String){
        if (email.isValidEmail() && password.isValidPassword()) {
            //loginFirebase(email, password)
        } else {
            userLoadError.value = true
        }
    }

    fun doLogin(user: String, pass: String) {

        val paramObject = JSONObject()
        paramObject.put("usuario", user)
        paramObject.put("contrasenia", pass)

        val params = paramObject.toString()
                .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

        val servicio: ApiInterface = api.create(ApiInterface::class.java)
        val result: Call<LoginResponse> = servicio.doLogin(params)

        result.enqueue(object: retrofit2.Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val responseCall = response.body()
                userLiveData.postValue(responseCall)
                Log.e("User Ingresado", "Login correcto")
                Log.e("Login", responseCall.toString())
                /*if (responseCall!!.isEmpty()) {
                   userServiceResponse.value = false
                   val gson = Gson()
                   val message: ErrorResponse = gson.fromJson(response.errorBody()!!.charStream(), ErrorResponse::class.java)
                   if(message.error != null) {
                       Log.e("Error register user", message.error)
                   } else {
                       Log.e("Mensaje de error vacío", "No error")
                   }
               }*/
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("Error Login", "Usuario no logeado")
            }


        })

    }

    fun getUser() {
        val service: ApiInterface = api.create(ApiInterface::class.java)
        val result: Call<UserDataResponse> = service.getUsers()
        result.enqueue(object : retrofit2.Callback<UserDataResponse> {

            override fun onResponse(
                call: Call<UserDataResponse>,
                response: Response<UserDataResponse>
            ) {
                val users = response.body()
                userListString.postValue(users)
                Log.e("Usuarios", users.toString())
                Log.e("Success", "Entró al call")
            }

            override fun onFailure(call: Call<UserDataResponse>, t: Throwable) {
                Log.e("Servicio Usuarios", "Error servicio de usuarios")
            }


        })
    }

    fun loginFirebase(email:String, password: String){

        loading.value = true

        auth = FirebaseAuth.getInstance()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(Activity()) {
                if(it.isSuccessful){
                    Log.v("EVR_APP", "isSuccessful")
                    //userServiceResponse.value = true
                } else {
                    Log.v("EVR_APP", "error")
                    //userServiceResponse.value = false
                }
            }
    }


}