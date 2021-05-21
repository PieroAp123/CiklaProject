package com.capstone.cikla.user

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class User (
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