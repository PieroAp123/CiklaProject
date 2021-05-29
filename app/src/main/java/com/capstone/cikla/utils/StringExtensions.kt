package com.capstone.cikla.utils

import android.util.Log
import android.util.Patterns
import com.capstone.cikla.network.ErrorResponse
import com.google.gson.Gson
import okhttp3.ResponseBody

class StringExtensions() {

    companion object {
        fun gestionarReponse(isSuccessful: Boolean, mensaje: String, responseBody: ResponseBody) {
            if (isSuccessful) {
                Log.e("User Ingresado", mensaje)
            } else {
                val gson = Gson()
                val message: ErrorResponse = gson.fromJson(responseBody.charStream(), ErrorResponse::class.java)
                if (message.error != null) {
                    Log.e("Error register user", message.error)
                } else {
                    Log.e("Mensaje de error vacío", "No error")
                }
            }
        }
    }

}

fun String.isValidEmail() : Boolean{
    return this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean{
    return this.isNotEmpty() && this.length <= 12
}

fun String.containsDigit(): Boolean {
    return this.matches(Regex(".*[0-9]*."))
}

fun String.containsLetter(): Boolean {
    return this.matches(Regex(".*[A-Za-z]*."))
}


