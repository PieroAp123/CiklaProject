package com.capstone.cikla.screens.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.capstone.cikla.R
import com.capstone.cikla.screens.navigation.NavigationActivity
import com.capstone.cikla.screens.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity: AppCompatActivity() {

    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        viewModel.getUser()
        this.observerViewModel()
        button_identificarme.setOnClickListener {
            viewModel.doLogin(emailCikla.text.toString(), passCikla.text.toString())

            //goToNavigation()
        }
        register.setOnClickListener { goToRegister() }
    }

    fun observerViewModel(){
        viewModel.userLiveData.observe(this,  {
            if (it != null) {
                Toast.makeText(this, "Ingresaste con éxito", Toast.LENGTH_SHORT).show()
                goToNavigation()
            } else {
                Toast.makeText(this, "Usuario inexistente", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setup() {
        button_identificarme.setOnClickListener {
            if (emailCikla.text!!.isNotEmpty() && passCikla.text!!.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailCikla.text.toString(), passCikla.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful) {
                            goToNavigation()
                        } else {
                            showAlert()
                        }
                    }

            }
        }

    }

    private fun goToNavigation() {
        val intent = Intent(this, NavigationActivity::class.java)
        finish()
        startActivity(intent)
    }

    private fun goToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Error en la autenticación del usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    override fun onStart() {
        super.onStart()
        supportActionBar?.hide()
    }

}