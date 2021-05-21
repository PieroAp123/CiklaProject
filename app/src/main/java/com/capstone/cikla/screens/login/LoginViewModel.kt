package com.capstone.cikla.screens.login

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.cikla.network.ApiInterface
import com.capstone.cikla.network.ApiService
import com.capstone.cikla.network.ClientConfig
import com.capstone.cikla.user.User
import com.capstone.cikla.utils.isValidEmail
import com.capstone.cikla.utils.isValidPassword
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
            loginFirebase(email, password)
        } else {
            userLoadError.value = true
        }
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
                    userServiceResponse.value = true
                } else {
                    Log.v("EVR_APP", "error")
                    userServiceResponse.value = false
                }
            }
    }


}