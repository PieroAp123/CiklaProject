package com.capstone.cikla.screens.sede

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.cikla.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

class MapsActivity: AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_map_sede)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }

}