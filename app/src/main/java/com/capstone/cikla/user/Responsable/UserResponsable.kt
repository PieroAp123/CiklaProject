package com.capstone.cikla.user.Responsable

import com.capstone.cikla.user.User.Persona
import com.google.gson.annotations.SerializedName

data class UserResponsable(

    @SerializedName("id")
    val id: Int,

    @SerializedName("usuario")
    val user: String,

    @SerializedName("contrasenia")
    val pass: String,

    @SerializedName("correo")
    val email: String,

    @SerializedName("persona")
    val persona: Persona,

    @SerializedName("imagenPerfil")
    val imageProfile: String,

    @SerializedName("fechaCreacion")
    val dateCreation: String,

    @SerializedName("usuarioCreacion")
    val userCreation: Int,

    @SerializedName("estado")
    val status: String

)
