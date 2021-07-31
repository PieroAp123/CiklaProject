package com.capstone.cikla.screens.navigation

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.capstone.cikla.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class NavigationActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController(R.id.fragment)
        bottomNavigationView.setupWithNavController(navController)



        /*val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController*/


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_nombre, menu)
        val userName = menu.findItem(R.id.nameUser)
        val user = userName?.actionView as TextView
        user.setTextColor(Color.WHITE)
        return super.onCreateOptionsMenu(menu)
    }

}