package com.capstone.cikla.screens.splash

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.capstone.cikla.R
import com.capstone.cikla.screens.login.LoginActivity

class CiklaActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        android.os.Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }, 1300)

    }

    override fun onStart() {
        super.onStart()
        supportActionBar?.hide()
    }

}