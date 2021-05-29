 package com.capstone.cikla.screens.register

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.cikla.network.ApiInterface
import com.capstone.cikla.network.ApiService
import com.capstone.cikla.network.ErrorResponse
import com.capstone.cikla.network.UserResponse
import com.capstone.cikla.user.Persona
import com.capstone.cikla.user.User
import com.capstone.cikla.utils.StringExtensions
import com.capstone.cikla.utils.isValidEmail
import com.capstone.cikla.utils.isValidPassword
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


 class RegisterViewModel: ViewModel() {

    lateinit var auth: FirebaseAuth

    val userRegisterServiceResponse = MutableLiveData<Boolean>()
    val userLoadError = MutableLiveData<Boolean>()
     val api = ApiService().getRetrofit()


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

    fun saveUser(user: String, pass: String, email: String, numberDocument: String, nameLastName: String, direction: String, cellphoneNumber:String, phoneNumber:String,  sexOrientation: String, imageDni1: String, dateBirth: String, idDocument: Int,  statusP: String, status: String) {

        val paramObject = JSONObject()
        paramObject.put("usuario", user)
        paramObject.put("contrasenia", pass)
        paramObject.put("correo",email)

        val personaObject = JSONObject()
        paramObject.put("persona", personaObject)
        personaObject.put("numeroDocumento", numberDocument)
        personaObject.put("nombresApellidos", nameLastName)
        personaObject.put("direccion", direction)
        personaObject.put("celular", cellphoneNumber)
        personaObject.put("telefono", phoneNumber)
        personaObject.put("sexo", sexOrientation)
        personaObject.put("imagenDni1", imageDni1)
        personaObject.put("imagenDni2", "")
        personaObject.put("fechaNacimiento", dateBirth)

        val typeDocumentObject = JSONObject()
        typeDocumentObject.put("id", idDocument)
        personaObject.put("tipoDocumento", typeDocumentObject)
        personaObject.put("fechaCreacion", "")
        personaObject.put("usuarioCreacion", "")
        personaObject.put("estado", statusP)
        paramObject.put("imagenPerfil", "")
        paramObject.put("fechaCreacion", "")
        paramObject.put("usuarioCreacion", "")
        paramObject.put("estado", status)

        val params = paramObject.toString()
                .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

        val servicio: ApiInterface = api.create(ApiInterface::class.java)
        val result: Call<UserResponse>  = servicio.newUser(params)

        result.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val users = response.body()
                //StringExtensions.gestionarReponse(response.isSuccessful, users!!.message, response.errorBody()!!)
                if (response.isSuccessful) {
                    Log.e("User Ingresado", users!!.message)
                } else {
                    val gson = Gson()
                    val message: ErrorResponse = gson.fromJson(response.errorBody()!!.charStream(), ErrorResponse::class.java)
                    if (message.error != null) {
                        Log.e("Error register user", message.error)
                    } else {
                        Log.e("Mensaje de error vacío", "No error")
                    }
                }
            }



            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Servicio Uses", "Error servicio ingresar usuario")
            }


        })

    }























}