package com.capstone.cikla.screens.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.cikla.R
import com.capstone.cikla.screens.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       goToNavigation()

    }

    private fun goToNavigation() {
        button_identificarme.setOnClickListener {
            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        supportActionBar?.hide()
    }

}