package com.capstone.cikla.screens.login

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.cikla.network.*
import com.capstone.cikla.user.User
import com.capstone.cikla.utils.isValidEmail
import com.capstone.cikla.utils.isValidPassword
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginViewModel: ViewModel() {

    lateinit var auth: FirebaseAuth

    val userLoadError = MutableLiveData<Boolean>() //notificar una accion o error
    val userServiceResponse = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    private val userListString = MutableLiveData<List<User>>()
    private val api = ApiService().getRetrofit()

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
                userServiceResponse.value = true
                if (response.isSuccessful) {
                    response.body()
                    Log.e("User Ingresado", "Login correcto")


                } else {
                    userServiceResponse.value = false
                    val gson = Gson()
                    val message: ErrorResponse = gson.fromJson(response.errorBody()!!.charStream(), ErrorResponse::class.java)
                    if(message.error != null) {
                        Log.e("Error register user", message.error)
                    } else {
                        Log.e("Mensaje de error vacío", "No error")
                    }
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("Servicio Login", "Error servicio de Login")
            }

        })

    }

    fun getUser() {
        val service: ApiInterface = api.create(ApiInterface::class.java)
        val result: Call<List<User>> = service.getUsers()
        result.enqueue(object : retrofit2.Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val users = response.body()
                userListString.postValue(users)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("Unsucces", "No entró al call")
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