package com.capstone.cikla.screens.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.capstone.cikla.R
import com.capstone.cikla.screens.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity: AppCompatActivity() {

    lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)

        buttonRegister.setOnClickListener {
            viewModel.register(regEmailCikla.text.toString(), regPassCikla.text.toString())
        }

        observerViewModel()

    }

    fun observerViewModel(){
        viewModel.userRegisterServiceResponse.observe(this, Observer {
            if (it){
                Toast.makeText(this,"Registrado con éxito", Toast.LENGTH_SHORT).show()
                goLogin()
            } else{
                Toast.makeText(this,"Verifique sus datos ingresados", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun goLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun onStart() {
        super.onStart()
        supportActionBar?.hide()
    }

}