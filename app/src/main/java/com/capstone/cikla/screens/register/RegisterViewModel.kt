package com.capstone.cikla.screens.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.cikla.utils.isValidEmail
import com.capstone.cikla.utils.isValidPassword
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel: ViewModel() {

    lateinit var auth: FirebaseAuth

    val userRegisterServiceResponse = MutableLiveData<Boolean>()
    val userLoadError = MutableLiveData<Boolean>() //notificar una accion o error

    fun register(email:String, pass:String){
        if (email.isValidEmail() && pass.isValidPassword()) {
            registerFirebase(email, pass)

        } else {
            userLoadError.value = true
        }
    }

    fun registerFirebase(email: String,pass: String){
        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    Log.v("EVR_APP", "isSuccessful")
                    userRegisterServiceResponse.value = true
                } else {
                    Log.v("EVR_APP", "error")
                    userRegisterServiceResponse.value = false
                }
            }
    }

}